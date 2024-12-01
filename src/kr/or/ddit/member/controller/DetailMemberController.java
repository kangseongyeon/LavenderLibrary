package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.RentalVO;
import kr.or.ddit.book.vo.ReservVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/member/detail.do")
public class DetailMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		IMemberService memService = MemberServiceImpl.getInstance();
		IBookService bookService = BookService.getInstance();
		MemberVO mv = memService.memInfo(memId);
		List<ReservVO> revList = bookService.getMemReserv(memId);
		List<RentalVO> rentalList = bookService.getMemRental(memId);
		req.setAttribute("mv", mv);
		req.setAttribute("revList", revList);
		req.setAttribute("rentalList", rentalList);

		req.getRequestDispatcher("/views/admin/memDetail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String memId=req.getParameter("memId");
		IMemberService memService=MemberServiceImpl.getInstance();
		int cnt=0;
		if (action != null) {
			if (action.equals("blacklist")) {
				cnt=memService.insertBlacklist(memId);
			} else if (action.equals("warnIncrease")) {
				cnt=memService.plusMemWarn(memId);
			} else if (action.equals("warnDecrease")) {
				cnt=memService.minusMemWarn(memId);
			}
		}
		
		String msg="";
		if(cnt>0) {
			//삭제 성공
			msg="SUCCESS";
		}else {
			//삭제 실패
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); //세션에 담기
		resp.sendRedirect(req.getContextPath()+"/member/detail.do?memId="+memId);
	}
}
