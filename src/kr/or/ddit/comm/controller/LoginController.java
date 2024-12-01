package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher("/views/main/login.jsp").forward(request, response);
    	
    	
    }
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uId = request.getParameter("userId");
		String uPw = request.getParameter("userPw");
	
		Map<String, Object> map = new HashMap();
		
		map.put("uId", uId);
		map.put("uPw", uPw);
		
		//서비스객체 얻기
		IMemberService memberService = MemberServiceImpl.getInstance();

		
		MemberVO mv = memberService.loginChk(map);
		
		System.out.println("mv 정보>>"+mv);
		//////
		if(Objects.isNull(mv) || "Y".equals(mv.getDelYn()) ) {
			System.out.println("회원정보 검증 결과0 >>");
//			System.out.println("회원정보 탈퇴 검증 >>" + mv.getDelYn());
			response.sendRedirect(request.getContextPath() + "/views/main/login.jsp?error=1");
		}else {
			
			mv.getMemId();
			mv.getBanYn();
			
			System.out.println("회원정보 검증 결과1 >>" + mv.getMemId());
			System.out.println("회원정보 검증 결과 2 >>" + mv.getBanYn());
			
			if(mv.getMemId() != null) {
				// 세션은 하나의 브라우저 내에서 정보/값을 공유 (주로 로그인 정보/상태를 유지할 때 사용)
				HttpSession session = request.getSession(); 
				session.setAttribute("loginCode", mv.getMemId());
				session.setAttribute("memId", uId); 
				session.setAttribute("memPass", uPw); 
				session.setAttribute("Welcome", "1"); 
				
				if ("b1a4".equals(mv.getMemId())) {
					response.sendRedirect(request.getContextPath() + "/main.do");
					
				}else if("Y".equals(mv.getBanYn())) {
					response.sendRedirect(request.getContextPath() + "/views/main/login.jsp?error=2");
				}
				else {
					
					response.sendRedirect(request.getContextPath() + "/main.do");
				}
		

			}
		}
		
	}
}
