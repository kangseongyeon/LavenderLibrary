package kr.or.ddit.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/rental/return.do")
public class ReturnBookController extends HttpServlet {
	private final static String MAILID = "lavender-b1a4@naver.com"; // naver mail주소 입력
	private final static String PASSWORD = "fkqpsej135!!"; // mail 비밀번호 입력

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String rentalNo = req.getParameter("rentalNo");
        IBookService bookService = BookService.getInstance();
        IMemberService memService=MemberServiceImpl.getInstance();
        int cnt = bookService.updateRental(rentalNo);
        bookService.updateBookRental(bookId);
        List<MemberVO> revMemList=memService.getRevMemList(bookId);

        String msg = "";
        if (cnt > 0) {
            msg = "SUCCESS";
            // 책 반납 성공 시 예약자들에게 이메일 발송
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

            // 예약자 목록 조회 (이 부분은 실제 데이터베이스에서 조회하도록 구현해야 합니다)
            int i=1;
            for (MemberVO mv: revMemList) {
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(MAILID));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(mv.getMemEmail()));

                    message.setSubject("[도서관] 예약하신 도서가 반납되었습니다");

                    message.setText("예약하신 도서 [" + bookName + "]가 반납되었습니다.\n"
                            + "현재 귀하의 대기 순번은 " + i + "번입니다.");

                    Transport.send(message);
                    System.out.println("이메일 발송 성공: " + mv.getMemEmail());
                    i++;
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        } else {
            msg = "FAIL";
        }
        req.getSession().setAttribute("msg", msg);

        resp.sendRedirect(req.getContextPath() + "/rental/list.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}