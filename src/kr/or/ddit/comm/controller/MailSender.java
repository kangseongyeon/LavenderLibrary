package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;



@WebServlet("/mailsender.do")
public class MailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String MAILID = "lavender-b1a4@naver.com"; // naver mail주소 입력
	private final static String PASSWORD = "fkqpsej135!!"; // mail 비밀번호 입력
       
    public MailSender() {
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1);
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MAILID, PASSWORD);
			}
		});
		
		String to = request.getParameter("to");
		String memPass = request.getParameter("num");
		
		String memId = request.getParameter("mem_id");
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MAILID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("[LavenderLibrary] 관리자");

			message.setText("\n임시 비밀번호는  [" + memPass + "] 입니다. \n\n임시 비밀번호로 로그인 후 비밀번호를 바꿔주세요!");
			
			Transport.send(message);
			System.out.println("message sent successfully...");
			response.getWriter().print(1);
			
			IMemberService memberService = MemberServiceImpl.getInstance();
			
			MemberVO mv = new MemberVO();
			mv.setMemId(memId);
			mv.setMemPass(memPass);
			
			int cnt = memberService.updatePassword(mv);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
//		String uId = request.getParameter("mem_id");
//		
//		IMemberService memberService = MemberServiceImpl.getInstance();
//		
//		MemberVO mv = new MemberVO();
//		mv.setMemId(uId);
//		mv.setMemPass(vNum);
//		
//		int cnt = memberService.updateMember(mv);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
