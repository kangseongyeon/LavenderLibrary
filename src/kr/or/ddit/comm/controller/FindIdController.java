package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;




@WebServlet("/FindId.do")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindIdController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher("/views/main/findId.jsp").forward(request, response);
    	
    	
    }
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uTel = request.getParameter("mem_tel");
		String uEmail = request.getParameter("mem_email");
	
		Map<String, Object> map = new HashMap();
		
		map.put("uTel", uTel);
		map.put("uEmail", uEmail);
		
		//서비스객체 얻기
		IMemberService memberService = MemberServiceImpl.getInstance();
		String memId = memberService.FindId(map);
		
		System.out.println("아이디 확인 잘들어오나 확인!!! >>" + memId);
		

		//$.ajax
		response.setContentType("application/json");
		
		response.getWriter().print("{\"memId\": \"" +  memId + "\"}");
		
	}
	
}
