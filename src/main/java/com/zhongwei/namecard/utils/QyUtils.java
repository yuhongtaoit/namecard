package com.zhongwei.namecard.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;

import net.sf.json.JSONObject;

@Service
public class QyUtils {

	private static final Logger logger = LoggerFactory.getLogger(QyUtils.class);

	@Autowired
	private SetQYMapper setQYMapper;

	@Autowired
	private CardMapper cardMapper;

	@Autowired
	private static SetQYMapper setQYMapperStatic;

	@Autowired
	private static CardMapper cardMapperStatic;

	@Autowired
	private WxMaProperties properties;

	@Autowired
	private static WxMaProperties wxMaProperties;

	private static String baseFilePath;// 资源文件绝对地址目录
	@Value(value = "${file.basefilepath}")
	private String filePath;// 资源文件绝对地址目录

	@PostConstruct
	public void init() {
		wxMaProperties = properties;
		setQYMapperStatic = setQYMapper;
		cardMapperStatic = cardMapper;
		baseFilePath = filePath;
	}

	public static int checkQyLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer uniacid = Integer.valueOf(request.getParameter("uniacid"));
		List<SetQY> qyList = new ArrayList<SetQY>();
		SetQYExample qyExample = new SetQYExample();
		qyExample.createCriteria().andUniacidEqualTo(uniacid);
		qyList = setQYMapperStatic.selectByExample(qyExample);
		SetQY setQY = qyList.size() > 0 ? qyList.get(0) : new SetQY();
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		if (userId == null || !StringUtils.hasText(userId.toString())) {
			 String redirectUri = wxMaProperties.getProjectRootPath() +"staffer/stafferIndex";
//			 String redirectUri = "http://192.168.43.210:8080/" +"staffer/stafferIndex";
			 String scope = "snsapi_base";
			 String codeUrl = getCodeUrl(setQY, redirectUri, scope);
			 String qytoken = QySendUtils.getAccessToken(setQY.getCorpid(),
			 setQY.getSecret(), setQY.getUniacid());
			 userId = webOauth(request, response, setQY, codeUrl, qytoken);
			 if(!StringUtils.hasText(userId)) {
				 return -1;
			 }
//			return -2;
//			userId = "qutianshou"; // 测试******
			request.getSession().setAttribute("session_dbs_masclwlcard_usderid", userId);
		}
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId).andIsSendcardEqualTo(0);
		List<Card> cardlist = cardMapperStatic.selectByExample(cardExample);
		if (cardlist.size() == 0) {
			return -2;
		} else {
			return 1;
		}
	}

	public static String getCodeUrl(SetQY setQY, String redirectUri, String scope) throws UnsupportedEncodingException {
		redirectUri = URLEncoder.encode(redirectUri, "UTF-8");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + setQY.getCorpid() + "&redirect_uri="
				+ redirectUri + "&response_type=code&scope=" + scope + "&agentid=" + setQY.getSecret()
				+ "&state=STATE#wechat_redirect";
		return url;
	}

	public static String webOauth(HttpServletRequest request, HttpServletResponse response, SetQY setQY, String codeUrl,
			String qytoken) throws IOException {
		String userId = null;
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		if (!StringUtils.hasText(code) && !StringUtils.hasText(state)) {
			response.sendRedirect(codeUrl);
//			HttpClientUtils.get(codeUrl);
//			return null;
		}
		if (StringUtils.hasText(code)) {
			String geturl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=" + qytoken + "&code="
					+ code;
			JSONObject json = HttpClientUtils.get(geturl);// ******
			try {
				userId = json.getString("UserId");
			} catch (Exception e) {
				return null;
			}
			if (!StringUtils.hasText(userId)) {
				logger.info("请在企业微信打开");
			}
		}
		return userId;
	}

	public static String downloadImage(Integer uniacid,  String mediaId, int cardId) throws Exception {
		List<SetQY> qyList = new ArrayList<SetQY>();
		SetQYExample qyExample = new SetQYExample();
		qyExample.createCriteria().andUniacidEqualTo(uniacid);
		qyList = setQYMapperStatic.selectByExample(qyExample);
		SetQY setQY = qyList.size() > 0 ? qyList.get(0) : new SetQY();
		String token = QySendUtils.getAccessToken(setQY.getCorpid(), setQY.getSecret(), uniacid);
		String returnPath = "";
		Calendar calender = Calendar.getInstance();
		String finalFileName = mediaId + ".jpg";
		returnPath = "attachment/images/" + calender.get(Calendar.YEAR) + "/" + (calender.get(Calendar.MONTH) + 1) + "/"
				+ calender.get(Calendar.DAY_OF_MONTH) + "/";
		File filePath = new File(baseFilePath + returnPath);
		if (!filePath.exists() && !filePath.isDirectory()) {
			System.out.println("目录不存在，创建目录：" + filePath);
			filePath.mkdir();
		}
//		saveImageToDisk(token, mediaId, finalFileName, baseFilePath + returnPath);
		fetchTmpFile(mediaId, token, baseFilePath + returnPath);
		return returnPath + finalFileName;

	}
	
	private static void fetchTmpFile(String media_id, String token,String path) {
		try {
			String url = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=" + token + "&media_id="
					+ media_id;
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			String content_disposition = conn.getHeaderField("Content-disposition");
			// 微信服务器生成的文件名称
			String file_name = "";
			if(StringUtils.hasText(content_disposition)) {
				String[] content_arr = content_disposition.split(";");
				if (content_arr.length == 2) {
					String tmp = content_arr[1];
					int index = tmp.indexOf("\"");
					file_name = tmp.substring(index + 1, tmp.length() - 1);
				}
			}else {
				file_name = media_id+".jpg";
			}
			// 生成不同文件名称
			File file = new File(path + file_name);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buf = new byte[2048];
			int length = bis.read(buf);
			while (length != -1) {
				bos.write(buf, 0, length);
				length = bis.read(buf);
			}
			bos.close();
			bis.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static InputStream getInputStream(String accessToken, String mediaId) {
		InputStream is = null;
		String url = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=" + accessToken + "&media_id="
				+ mediaId;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			// 获取文件转化为byte流
			is = http.getInputStream();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;

	}

	private static void saveImageToDisk(String accessToken, String mediaId, String picName, String picPath)
			throws Exception {
		InputStream inputStream = getInputStream(accessToken, mediaId);
		byte[] data = new byte[10240];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(picPath + picName);
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



}
