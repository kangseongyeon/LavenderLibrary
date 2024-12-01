package kr.or.ddit.answer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.answer.service.AnswerServiceImpl;
import kr.or.ddit.answer.service.IAnswerService;
import kr.or.ddit.vo.AnswerVO;

@WebServlet("/answer/update.do")
public class UpdateAnswerController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inqNo = req.getParameter("inqNo");
        
        IAnswerService answerService = AnswerServiceImpl.getInstance();
        
        AnswerVO av = answerService.getAnswer(inqNo);
        
        req.setAttribute("av", av);
        
        req.getRequestDispatcher("/views/answer/answerUpdate.jsp").forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answerTitle = req.getParameter("answerTitle");
		String answerContent = req.getParameter("answerContent");
		String inqNo = req.getParameter("inqNo");
		
		IAnswerService answerService = AnswerServiceImpl.getInstance();
		
		AnswerVO av = new AnswerVO(answerTitle, answerContent, inqNo);
		
		int cnt = answerService.modifyAnswer(av);
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
