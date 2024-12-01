package kr.or.ddit.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.news.service.INewsService;
import kr.or.ddit.news.service.NewsServiceImpl;
import kr.or.ddit.vo.NewsVO;

@WebServlet("/news/detail.do")
public class DetailNewsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newsNo = req.getParameter("newsNo");
		
		INewsService newsService = NewsServiceImpl.getInstance();
		
		NewsVO nv = newsService.getNews(newsNo);
		
		req.setAttribute("nv", nv);
		
		// 첨부파일 추가하기
		if (nv.getAtchFileId() > 0) {	 // 첨부파일이 존재하는 경우...
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			AtchFileVO atchFileVO = new AtchFileVO();
			atchFileVO.setAtchFileId(nv.getAtchFileId());
			atchFileVO = fileService.getAtchFile(atchFileVO);
			
			req.setAttribute("atchFileVO", atchFileVO);
		}
		
		req.getRequestDispatcher("/views/news/newsDetail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}