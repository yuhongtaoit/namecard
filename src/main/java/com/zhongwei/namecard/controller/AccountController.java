package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AccountWxappExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountWxappMapper accountMapper;
	
	private int pageSize = 2;//每页大小
	
	private int pageNo = 1;//第几页，初始值为1
	
	@RequestMapping("/getAccountList")
	public String getUsers(Model model, Integer pindex, Principal principal, Authentication authentication) {
		if(pindex == null) 
			pindex = 0;
		
		if(pindex<1) {
			pindex = pageNo;
		}
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		PageHelper.startPage(pindex, pageSize);
		AccountWxappExample accountExample = new AccountWxappExample();
		accountExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<AccountWxapp> accountList = this.accountMapper.selectByExample(accountExample);
		model.addAttribute("accountList", accountList);
		return "accountlist";
	}
	
	@RequestMapping("/getAccountTotal")
	public @ResponseBody CommonMessage getAccountTotal(Model model, Principal principal, Authentication authentication) {
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		AccountWxappExample accountExample = new AccountWxappExample();
		accountExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		int total = accountMapper.countByExample(accountExample);
		if(total == 0) {
			total=1;
		}
		message.setSuccess(true);
		message.setMessage(String.valueOf(total%pageSize==0?total/pageSize:total/pageSize+1));
		return message;
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
	public @ResponseBody CommonMessage saveAccount(HttpServletRequest request, HttpServletResponse response, Principal principal, Authentication authentication, AccountWxapp account){
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		account.setUniacid(user.getUniacid());
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
    	account.setLevel(account.getLevel()==null?1:account.getLevel().byteValue());
    	account.setName(account.getName()==null?"":account.getName());
    	account.setOriginal(account.getOriginal()==null?"":account.getOriginal());
    	account.setSecret(account.getSecret()==null?"":account.getSecret());
    	account.setToken(account.getToken()==null?"":account.getToken());
    	account.setUniacid(account.getUniacid()==null?0:account.getUniacid());
    	return account;
    }
}