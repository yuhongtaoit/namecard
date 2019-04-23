package com.zhongwei.namecard.service;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.CardWithBLOBs;

@Service
public class MiniQrService {
	
	@Value(value = "${file.basefilepath}")
	private String baseFilePath;//资源文件绝对地址目录
	
	@Autowired
	private CardMapper cardMapper;
	
	public void getMiniQr(String sceneStr, String accessToken ,Integer uniacid, Integer cardId) {
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+accessToken;
            Map<String,Object> param = new HashMap<>();
            param.put("scene", sceneStr);
            param.put("page", "dbs_masclwlcard/pages/home/home");
            param.put("width", 430);
            param.put("auto_color", false);
            Map<String,Object> line_color = new HashMap<>();
            line_color.put("r", 0);
            line_color.put("g", 0);
            line_color.put("b", 0);
            param.put("line_color", line_color);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            @SuppressWarnings({ "unchecked", "rawtypes" })
			HttpEntity requestEntity = new HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
            byte[] result = entity.getBody();
            inputStream = new ByteArrayInputStream(result);

            String baseFilePath = this.baseFilePath+"attachment/images/"+uniacid+"/";
            File filePath = new File(baseFilePath);
    		if (!filePath.exists() && !filePath.isDirectory()) {
    		    System.out.println("目录不存在，创建目录：" + filePath);
    		    filePath.mkdirs();
    		}
            File file = new File(this.baseFilePath+"attachment/images/"+uniacid+"/"+cardId+".png");
            if (!file.exists()){
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
            this.setMiniQrWithLogo(sceneStr, accessToken, uniacid, cardId);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	private void setMiniQrWithLogo(String sceneStr, String accessToken ,Integer uniacid, Integer cardId) {
		try {
			//此处是要替代logo的自定义图片路径，自定义图片不要用透明的或者半透明的
			CardWithBLOBs card = this.cardMapper.selectByPrimaryKey(cardId);
			String logoPath = card.getCardLogo();
			BufferedImage image = ImageIO.read(new File(baseFilePath+logoPath));
		    //int w = image.getWidth();
		    //int h = image.getHeight();
		    BufferedImage output = new BufferedImage(195, 195, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = output.createGraphics();
		    output = g2.getDeviceConfiguration().createCompatibleImage(195, 195, Transparency.TRANSLUCENT);
		    g2.dispose();
		    g2 = output.createGraphics();
		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g2.fillRoundRect(0, 0,195, 195, 720, 720);
		    g2.setComposite(AlphaComposite.SrcIn);
		    g2.drawImage(image, 0, 0, 195, 195, null);
		    g2.dispose();
		    //这是生成的临时替换logo图片的保存路径
		    ImageIO.write(output, "png", new File("E:/attachment/images/"+uniacid+"/"+cardId+"_logo.png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//生产新的二维码图片
		try {
			//此处是小程序码的路径
		    BufferedImage appletImg = ImageIO.read(new FileInputStream("E:/attachment/images/"+uniacid+"/"+cardId+".png"));
		    Graphics2D g2d = appletImg.createGraphics();
		    // 设置抗锯齿的属性  
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		    //此处是替换logo的临时图片路径
		    BufferedImage centerImg = ImageIO.read(new File("E:/attachment/images/"+uniacid+"/"+cardId+"_logo.png"));
		    g2d.drawImage(centerImg.getScaledInstance(centerImg.getWidth(), centerImg.getHeight(), Image.SCALE_SMOOTH), (appletImg.getWidth() - centerImg.getWidth()) / 2, (appletImg.getHeight() - centerImg.getHeight()) / 2, null);
		    // 关闭资源 
		    g2d.dispose();
		    //生成新的二维码，覆盖原来的，此处为原小程序码路径，如需另为保存，请自定义路径
		    ImageIO.write(appletImg, "png", new File("E:/attachment/images/"+uniacid+"/"+cardId+".png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new File("E:/attachment/images/"+uniacid+"/"+cardId+"_logo.png").delete();
			                    
	}
	
}
