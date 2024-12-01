package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;






@WebServlet("/Join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//RequestDispatcher객체가 요청을 원하는 위치로 전달하게 함
		request.getRequestDispatcher("/views/main/join.jsp").forward(request, response);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("mem_id");
		String memPass = req.getParameter("mem_pass");
		String memName = req.getParameter("mem_name");
		String memBir = req.getParameter("mem_bir");
		String memTel = req.getParameter("mem_tel");
		String memEmail = req.getParameter("mem_email");
		String memPostno = req.getParameter("mem_postno");
		String memAddr1 = req.getParameter("mem_addr1");
		String memAddr2 = req.getParameter("mem_addr2");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO MV = new MemberVO(); 
		MV.setMemId(memId);
		MV.setMemPass(memPass);
		MV.setMemName(memName);
		MV.setMemBir(memBir);
		MV.setMemTel(memTel);
		MV.setMemEmail(memEmail);
		MV.setMemPostno(memPostno);
		MV.setMemAddr1(memAddr1);
		MV.setMemAddr2(memAddr2);
		
		System.out.println(MV);
		
		int cnt = service.joinMem(MV);
		
		resp.getWriter().print(cnt);
		
		
		
	}
	


}
