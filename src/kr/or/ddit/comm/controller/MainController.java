package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServicempl;
import kr.or.ddit.vo.EventVO;
import kr.or.ddit.vo.NoticeVO;


@WebServlet("/main.do")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        INoticeService noticeService = NoticeServicempl.getInstance();
        IBookService bookService=BookService.getInstance();
        IEventService eventService = EventServiceImpl.getInsetance();
        
        List<NoticeVO> noticeList = noticeService.getTotalNotice();
        List<BookVO> bookList=bookService.getNewList();
        List<EventVO> eventList = eventService.getTotalLibEvent();
        
        // 공지사항 리스트를 세션에 저장
        HttpSession session = req.getSession();
        session.setAttribute("noticeList", noticeList);
        session.setAttribute("bookList", bookList);
        session.setAttribute("eventList", eventList);

        // 공지사항 리스트를 request 객체에 저장
        req.setAttribute("noticeList", noticeList);
        req.setAttribute("bookList", bookList);
        req.setAttribute("eventList", eventList);
        req.getRequestDispatcher("/views/main/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
