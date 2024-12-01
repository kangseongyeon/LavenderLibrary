package kr.or.ddit.answer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.answer.service.AnswerServiceImpl;
import kr.or.ddit.answer.service.IAnswerService;
import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.InquiryVO;

@WebServlet("/answer/insert.do")
public class InsertAnswerController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inqNo = req.getParameter("inqNo");
	    HttpSession session = req.getSession();
	    if (inqNo != null && !inqNo.isEmpty()) {
	        session.setAttribute("inqNo", inqNo);
	    }
	    req.getRequestDispatcher("/views/answer/answerInsert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answerTitle = req.getParameter("answerTitle");
		String answerContent = req.getParameter("answerContent");
		String inqNo = req.getParameter("inqNo");
		

		IAnswerService answerService = AnswerServiceImpl.getInstance();

		AnswerVO av = new AnswerVO(answerTitle, answerContent, inqNo);

		int cnt = answerService.registerAnswer(av);

		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath() + "/inquiry/list.do");

	}
}
