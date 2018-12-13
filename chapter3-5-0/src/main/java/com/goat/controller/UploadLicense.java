package com.goat.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Properties;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.goat.bean.ValidMessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/uploadLicense")
public class UploadLicense {
//	@Value("${upload.uploadFileDiskPath}")
	private String fileDiskPath = "E:\\Code\\License\\";
	
	@RequestMapping("/gotoPage")
	public String gotoPage() {
		return "/web/uploadPage";
	}

	@RequestMapping("/upload")
	@ResponseBody
	public ValidMessageDTO upload(@RequestParam("license") MultipartFile license) {
		ValidMessageDTO vmd = new ValidMessageDTO();
		try {
			InputStream is = license.getInputStream();
			String name = license.getOriginalFilename();
			OutputStream os = new FileOutputStream(fileDiskPath + name);
			byte b[] = new byte[1024];
			int len = 0;
			while((len = is.read(b)) > -1) {
				os.write(b, 0, len);
			}
			is.reset();
			String signature = getSignature(is);
			writeProp(signature, name);
			os.flush();
			os.close();
			is.close();
			vmd.setMsg("上传成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vmd.setMsg("上传失败");
		}
		return vmd;
	}

	public String getSignature(InputStream is) throws CertificateException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		Certificate c = cf.generateCertificate(is);
		X509Certificate x = (X509Certificate) c;
        String signature = new BigInteger(x.getSignature()).toString(16);
		return signature;
	}

	public void writeProp(String signature, String name) throws IOException {
		Properties props = new Properties();
		props.load(PropertyUtil.class.getResourceAsStream("/license.properties"));
		props.setProperty("signature", signature);
		props.setProperty("name", name);
		FileOutputStream out = new FileOutputStream("" + "license.properties");
		props.store(out, "");
		out.close();
	}

}
