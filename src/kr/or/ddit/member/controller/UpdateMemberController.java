package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@MultipartConfig
@WebServlet("/member/update.do")
public class UpdateMemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public UpdateMemberController() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(); 

		MemberVO mv= new MemberVO();
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		String memId = (String) session.getAttribute("memId");
		String memPass = (String) session.getAttribute("memPass");
		

		

		
		mv = memService.memInfo(memId);
		
		req.setAttribute("mv", mv);
		
		req.getRequestDispatcher("/views/member/updateFormM.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		///여기서 수정한 정보 불러오기
		String memId = req.getParameter("mem_id");
		String memPass = req.getParameter("mem_pass");
		String memTel = req.getParameter("mem_tel");
		String memEmail = req.getParameter("mem_email");
		String memPostno = req.getParameter("mem_postno");
		String memAddr1 = req.getParameter("mem_addr1");
		String memAddr2 = req.getParameter("mem_addr2");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO MV = new MemberVO(); 
		MV.setMemId(memId);
		MV.setMemPass(memPass);
		MV.setMemTel(memTel);
		MV.setMemEmail(memEmail);
		MV.setMemPostno(memPostno);
		MV.setMemAddr1(memAddr1);
		MV.setMemAddr2(memAddr2);
		
		int cnt = memService.updateMember(MV);
		
		resp.getWriter().print(cnt);
		

		

		
		
	}
	
	
	

}
