package kr.or.ddit.book.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.BookVO;

@WebServlet("/book/list.do")
public class ListBookController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBookService bookService= BookService.getInstance();
		
		List<BookVO> bookList= bookService.getAllBook();
		req.setAttribute("bookList", bookList);
		
		//페이징처리
		int currentPage = 1; //현재 페이지
		currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		
		
		//전체 글 갯수 , 총 데이터 개수
		int totalCount = bookService.countList();

		//화면에 표시될 페이지의 수
		int perPage = 5;
		
		//한 페이지 당 출력할 글 갯수
		int perList = 10;
		
		//◆전체 페이지 수 = 전체 글 갯수(totalCount) / 페이지 당 글 갯수(perList)
		// *형 변환으로 정확한 값을 도출
//		int totalPage = 21 / perList; //5page가 나와야 하지만 그렇지 못함 
		int totalPage = (int)Math.ceil((double)totalCount / (double)perList);  
		//(double)은 한쪽만 있어도 되는데 해주는 이유는 하나라도 실수 타입이어야지 나누기를 했을때 소수점이 있어서 올림을 하는 의미가 있다
		// double을 올림해주면 여전히 double이라 3.0같은 형태가 되고 int로 받고 있으므로 형변환을 (int)로 해준다
		// (double)12/10 -> ceil(1.2) -> Integer(2.0) -> 2 => 전개 글이 12개이고 10개씩 한페이지에 보여줄때 필요한 페이지수 의미
		System.out.println("totalPage" + totalPage);
		
		//◆페이지 별 게시글 범위(start ~ end) 구하기
		//start = (currentPage - 1) * perList + 1;
		// 1page: (1-1)*10+1 = 1 | 2page: (2-1)*10+1 =11 | 3page: (3-1)*10+1 = 21 | 4page: (4-1)*10+1 = 31
		int start = (currentPage - 1) * perList + 1;

		//end = start + perList - 1;
		// 1page: 1+10-1 = 10 | 2page: 11+10-1 = 20 | 3page: 21+10-1 = 30 | 4page: 31+10-1 = 40
		int end = start + perList - 1;
		if(end > totalCount) end = totalCount; // *전체 글 갯수 초과 값 조절
		
		
		//◆페이지 범위(startPage ~ endPage) 구하기
		//startPage = ((currentPage - 1) / perPage * perPage) + 1;
		int startPage = ((currentPage - 1) / perPage * perPage) + 1;
		
		//endPage = startPage + perPage - 1;
		//endPage = 1 +  - 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
//		
//		//범위 별 게시물 가져오기
		List<BookVO> list = bookService.boardList(map);
		System.out.println("list" + list);

		//req에 결과데이터를 담아서 페이지로 전달
		req.setAttribute("list", list);
		req.setAttribute("start", start); //게시글 순번 적용시 전체 게시물에 순차적인 넘버링을 적용하기 위해 사용(str + index)
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("totalCount", totalCount); //total
		req.setAttribute("currentPage", currentPage); //페이지번호 활성화 조건으로 사용

		req.setAttribute("active", "list");
		req.getRequestDispatcher("/views/book/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
