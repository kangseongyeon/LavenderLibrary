package kr.or.ddit.answer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.answer.service.AnswerServiceImpl;
import kr.or.ddit.answer.service.IAnswerService;

@WebServlet("/answer/delete.do")
public class DeleteAnswerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inqNo = req.getParameter("inqNo");
        
        if (inqNo == null || inqNo.isEmpty()) {
            req.getSession().setAttribute("msg", "FAIL");
            resp.sendRedirect(req.getContextPath() + "/inquiry/detail.do");
            return;
        }

        IAnswerService answerService = AnswerServiceImpl.getInstance();
        
        int cnt = answerService.removeAnswer(inqNo);
        
        String msg = "";
        if (cnt > 0) {
            msg = "SUCCESS";
        } else {
            msg = "FAIL";
        }
        
        req.getSession().setAttribute("msg", msg);
        
        resp.sendRedirect(req.getContextPath() + "/inquiry/list.do");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
