package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.vo.EventVO;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/Logout.do")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(false); if (session != null) { //
		 * 세션에 저장된 공지사항 리스트를 가져옴 List<NoticeVO> noticeList = (List<NoticeVO>)
		 * session.getAttribute("noticeList"); List<BookVO> bookList = (List<BookVO>)
		 * session.getAttribute("bookList"); List<EventVO> eventList = (List<EventVO>)
		 * session.getAttribute("eventList");
		 * 
		 * // 메인 페이지로 리다이렉트할 때 공지사항 리스트를 request 객체에 저장
		 * request.setAttribute("noticeList", noticeList);
		 * request.setAttribute("bookList", bookList); request.setAttribute("eventList",
		 * eventList); session.invalidate(); // 세션 종료 }
		 * 
		 * String message = URLEncoder.encode("로그아웃 되었습니다", "UTF-8");
		 * response.sendRedirect(request.getContextPath() + "/main.do?message=" +
		 * message);
		 */

//    	request.getSession().setAttribute("deletMem", memId); //세션에 담기
//    	String deletMem = (String) request.getSession().getAttribute("deletMem");
    	String deletMem = request.getSession().getAttribute("deletMem") == null ? "" : (String) request.getSession().getAttribute("deletMem");
    	String memId = (String) request.getSession().getAttribute("memId");

    	System.out.println("여기");
    	System.out.println(deletMem);
    	System.out.println(memId);
    	System.out.println("여기맞지");
    	if(deletMem.equals(memId)) {
    		
    		HttpSession session = request.getSession(false);
    		if (session != null) {
    			// 세션에 저장된 공지사항 리스트를 가져옴
    			List<NoticeVO> noticeList = (List<NoticeVO>) session.getAttribute("noticeList");
    			List<BookVO> bookList = (List<BookVO>) session.getAttribute("bookList");
    			List<EventVO> eventList = (List<EventVO>) session.getAttribute("eventList");
    			
    			// 메인 페이지로 리다이렉트할 때 공지사항 리스트를 request 객체에 저장
    			request.setAttribute("noticeList", noticeList);
    			request.setAttribute("bookList", bookList);
    			request.setAttribute("eventList", eventList);
    			session.invalidate(); // 세션 종료
    			
    		}
    		String message2 = URLEncoder.encode( "회원탈퇴 되었습니다", "UTF-8");
    		response.sendRedirect(request.getContextPath() + "/main.do?message2=" + message2);
    		
    	}else {
    		HttpSession session = request.getSession(false);
    		if (session != null) {
    			// 세션에 저장된 공지사항 리스트를 가져옴
    			List<NoticeVO> noticeList = (List<NoticeVO>) session.getAttribute("noticeList");
    			List<BookVO> bookList = (List<BookVO>) session.getAttribute("bookList");
    			List<EventVO> eventList = (List<EventVO>) session.getAttribute("eventList");
    			
    			// 메인 페이지로 리다이렉트할 때 공지사항 리스트를 request 객체에 저장
    			request.setAttribute("noticeList", noticeList);
    			request.setAttribute("bookList", bookList);
    			request.setAttribute("eventList", eventList);
    			session.invalidate(); // 세션 종료
    		}
    		
    		String message = URLEncoder.encode("로그아웃 되었습니다", "UTF-8");
    		response.sendRedirect(request.getContextPath() + "/main.do?message=" + message);
    	}
    	

     }
    	 
        
        
        
        
        
        
        
        
        
        
        

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}