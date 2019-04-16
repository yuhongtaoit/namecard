package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AccountWxappExample;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountWxappMapper accountMapper;
	
	@RequestMapping("/getAccountList")
	public String getUsers(Model model) {
		List<AccountWxapp> accountList = this.accountMapper.selectByExample(new AccountWxappExample());
		model.addAttribute("accountList", accountList);
		return "accountlist";
	}
	
	@RequestMapping("/editAccount")
	public String editAccount(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			AccountWxapp account = this.accountMapper.selectByPrimaryKey(id);
			model.addAttribute("account", account);
		}
		return "accountedit";
	}
	
	@RequestMapping("/saveAccount")
	@Transactional
	public @ResponseBody CommonMessage saveAccount(HttpServletRequest request, HttpServletResponse response, AccountWxapp account){
		CommonMessage message = new CommonMessage();
		this.setAccountDefaultValue(account);
		if(account!=null && account.getAcid()!=null){
			AccountWxapp oldAccount = this.accountMapper.selectByPrimaryKey(account.getAcid());
			if(oldAccount!=null && oldAccount.getAcid()!=0){
				this.accountMapper.updateByPrimaryKey(account);
				message.setSuccess(true);
				message.setMessage("保存成功！");
				return message;
			}else{
				message.setSuccess(false);
				message.setMessage("保存失败！");
				return message;
			}
		}
		this.accountMapper.insert(account);
		account.setUniacid(account.getAcid());
		this.accountMapper.updateByPrimaryKey(account);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
    @RequestMapping(value="/deleteAccount")
    @Transactional
    public @ResponseBody CommonMessage deleteAccount(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			this.accountMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
    
    private AccountWxapp setAccountDefaultValue(AccountWxapp account) {
    	account.setAccount(account.getAccount()==null?"":account.getAccount());
    	account.setAppdomain(account.getAppdomain()==null?"":account.getAppdomain());
    	account.setEncodingaeskey(account.getEncodingaeskey()==null?"":account.getEncodingaeskey());
    	account.setKey(account.getKey()==null?"":account.getKey());
    	account.setLevel(account.getLevel()==null?1:account.getLevel());
    	account.setName(account.getName()==null?"":account.getName());
    	account.setOriginal(account.getOriginal()==null?"":account.getOriginal());
    	account.setSecret(account.getSecret()==null?"":account.getSecret());
    	account.setToken(account.getToken()==null?"":account.getToken());
    	account.setUniacid(account.getUniacid()==null?0:account.getUniacid());
    	return account;
    }
}