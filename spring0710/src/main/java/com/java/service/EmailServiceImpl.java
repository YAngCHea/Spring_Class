package com.java.service;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	
	@Override //임시비밀번호 코드생성
	public String insertPwCode(String name, String email) {
		//
		System.out.println("EmailServiceImpl name : "+name);
		System.out.println("EmailServiceImpl email : "+email);
		
		//임시패스워드 코드 생성
		String pwcode = getCreateKey();
		System.out.println("EmailServiceImpl pwcode : "+pwcode);
		
		//이메일 발송 - 단순 txt
		//mailSendHtml(name,email,pwcode);
		//이메일 발송 - html
		mailSendHtml(name,email,pwcode);
		
		
		return pwcode;
	}
	
	//이메일 발송 - html
	public void mailSendHtml(String name, String email, String pwcode) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setSubject("[안내]"+name+"님 회원가입 이메일 인증 임시 비밀번호 안내","utf-8");
			String htmltxt = "<h3>안녕하세요.[ "+name+"} 님</h3>" + 
					"<h3 style = 'color:red'>임시 비밀번호 안내 : "+pwcode+"</h3>";
			
			//외부에서 html코드 가져오기
			htmltxt = htmltxt(name,pwcode);
			
			message.setText(htmltxt,"utf-8","html");
			message.setFrom(new InternetAddress("cheayouny@gmail.com"));  //보내는 사람
			message.addRecipient(RecipientType.TO, new InternetAddress(email));  //받는 사람
			mailSender.send(message);
			System.out.println("이메일 전송 완료!!!");
			
		} catch (MessagingException e) {
			e.printStackTrace();
			return;
		}//try/catch
	}//mailSendHtml
	
	
	
	
	
	public String htmltxt(String name,String pwcode) {
		String htmltxt = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\r\n"
				+ "<html xmlns='http://www.w3.org/1999/xhtml' lang='ko' xml:lang='ko'>\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv='Content-Type' content='application/xhtml+xml; charset=utf-8' />\r\n"
				+ "<meta http-equiv='X-UA-Compatible' content='IE=edge' />\r\n"
				+ "<title> 비밀번호 발송 </title>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "<body bgcolor='#FFFFFF' leftmargin='0' topmargin='0' marginwidth='0' marginheight='0' style='margin:0; padding:0; font:normal 12px/1.5 돋움;'>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<table width='700' cellpadding='0' cellspacing='0' align='center'>\r\n"
				+ "<tr>\r\n"
				+ "	<td style='width:700px;height:175px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;'>\r\n"
				+ "		<img src='http://localhost:8000/images/email/img_email_top.jpg' alt='JARDIN' />					\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style='width:700px;height:78px;padding:0;margin:0;vertical-align:top;'>\r\n"
				+ "		<p style='width:620px;margin:50px 0 40px 38px;text-align:center;font-size:0;line-height:0;'><img src='http://localhost:8000/images/email/img_txt_password01.jpg' alt='원두커피의 名家, JARDIN 임시 비밀번호가 발급되었습니다.' /></p>\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style='width:700px;height:196px;padding:0;margin:0;vertical-align:top;'>\r\n"
				+ "		<table width='618' height='194' cellpadding='0' cellspacing='0' align='center' style='margin:0 0 0 40px;border:1px #d9d9d9 solid;'>\r\n"
				+ "		<tr>\r\n"
				+ "			<td style='width:618px;height:194px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#f9f9f9;'>\r\n"
				+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;'><img src='http://localhost:8000/images/email/img_txt_password02.jpg' alt='JARDIN에서 비밀번호 찾기를 요청하셨습니다.' /></p>\r\n"
				+ "				<p style='width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;'>아래의 PASSWORD는 임시 PASSWORD이므로 홈페이지 로그인 후 다시 수정해 주십시오.</p>\r\n"
				+ "				<p style='width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;'><strong>임시 패스워드 : <span style='color:#f7703c;line-height:1;'>"+pwcode+"</span></strong></p>\r\n"
				+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;'>쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "		</table>	\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style='width:700px;height:120px;padding:0;margin:0;vertical-align:top;'>\r\n"
				+ "		<p style='width:700px;margin:30px 0 50px 0;text-align:center;'><a href='#'><img src='http://localhost:8000/images/email/btn_jardin.jpg' alt='JARDIN 바로가기' /></a></p>\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style='width:700px;height:50px;padding:0;vertical-align:top;font-size:0;line-height:0;text-align:center;'>\r\n"
				+ "		<img src='http://localhost:8000/images/email/img_email_bottom.jpg' alt='' />\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "	<td style='width:700px;height:140px;padding:0;margin:0;vertical-align:top;background-color:#5a524c;'>\r\n"
				+ "		<p style='width:620px;margin:20px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;'>메일수신을 원치 않으시는 분은 로그인 후. <span style='color:#ffffff'>메일 수신 여부</span>를 변경해주시기 바랍니다.<br/>IF YOU DO NOT WISH TO RECEIVE EMAILS FROM US, PLEASE LOG-IN AND UPDATE<br/> YOUR MEMBERSHIP INFORMATION.</p>\r\n"
				+ "\r\n"
				+ "		<p style='width:620px;margin:15px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;'><span style='color:#ffffff'>본 메일에 관한 문의사항은 사이트 내 고객센터를 이용해주시기 바랍니다.</span><br/>COPYRIGHT ©  2014 JARDIN ALL RIGHTS RESERVED.</p>\r\n"
				+ "	</td>\r\n"
				+ "</tr>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		return htmltxt;
	}
	
	
	//이메일 발송 - 단순 txt
	public void mailSend(String name, String email,String pwcode) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);     //setTo : ~에게 보낸다
		message.setFrom("cheayouny@gmail.com");     //setFrom:~가 보낸다
		message.setSubject(name + "님께 이메일 인증 임시번호를 발송합니다.");     //setSubject:제목
		message.setText("안녕하세요. 회원가입에 필요한 이메일 인증 임시 비밀번호를 안내 드립니다.\n" + "["+name+"님의 임시비밀번호 : "+pwcode+"]\n");
		
		mailSender.send(message);
		System.out.println("이메일이 발송 되었습니다!!");
		
		
	}//mailSend
	
	
	
	
	
	//임시패스워드 코드생성 메소드
	public String getCreateKey() {
		char[] charSet = {'0','1','2','3','4','5','6','7','8','9',
				          'a','b','c','d','e','f','g','h','i','j',
				          'k','l','m','n','o','p','q','r','s','t',
				          'u','v','w','x','y','z'};
		
		String pwcode="";
		int idx = 0;
		
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*36); //0-9, a-z까지의 랜덤번호
			pwcode += charSet[idx];
		}
		
		
		return pwcode;
	}
}