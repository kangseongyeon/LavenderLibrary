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
@WebServlet("/news/update.do")
public class UpdateNewsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newsNo = req.getParameter("newsNo");
		
		INewsService newsService = NewsServiceImpl.getInstance();
		
		NewsVO nv = newsService.getNews(newsNo);
		
		req.setAttribute("nv", nv);
		
		if (nv.getAtchFileId() > 0) {	 // 첨부파일이 존재하는 경우...
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			AtchFileVO atchFileVO = new AtchFileVO();
			atchFileVO.setAtchFileId(nv.getAtchFileId());
			atchFileVO = fileService.getAtchFile(atchFileVO);
			
			req.setAttribute("atchFileVO", atchFileVO);
		}
		
		req.getRequestDispatcher("/views/news/newsUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newsTitle = req.getParameter("newsTitle");
		String newsContent = req.getParameter("newsContent");
		long atchFileId = req.getParameter("atchFileId") == null ? -1
				: Long.parseLong(req.getParameter("atchFileId"));	// 기존 첨부파일 ID
		String newsNo = req.getParameter("newsNo");
		
		INewsService newsService = NewsServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();

		NewsVO nv = new NewsVO(newsNo, newsTitle, newsContent, atchFileId);
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());

		if(atchFileVO != null) {	// 새로 업로드 파일을 선택한 경우...
			nv.setAtchFileId(atchFileVO.getAtchFileId());
	    } else {	 // 새로운 첨부파일은 선택하지 않은 경우... (기존 첨부파일을 유지하고 싶은 경우)
	    	nv.setAtchFileId(atchFileId);
	    }
		
		int cnt = newsService.modifyNews(nv);
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
