package kr.or.ddit.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@MultipartConfig
@WebServlet("/news/insert.do")
public class InsertNewsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/news/newsInsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newsTitle = req.getParameter("newsTitle");
		String newsContent = req.getParameter("newsContent");
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		INewsService newsService = NewsServiceImpl.getInstance();
		 AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		NewsVO nv = new NewsVO(newsTitle, newsContent);
		
		if(atchFileVO != null) {
			nv.setAtchFileId(atchFileVO.getAtchFileId());
	    }
		
		int cnt = newsService.registerNews(nv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/news/list.do");
	}
}
