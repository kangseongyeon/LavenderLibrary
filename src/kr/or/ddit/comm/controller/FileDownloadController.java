package kr.or.ddit.comm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileDetailVO;

@WebServlet("/download.do")
public class FileDownloadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		long atchFileId = 18; /// 있는 파일로 잘 해야 한다(업로트폴더에), 디비 보고 했다
//		long atchFileId = 19; /// 한글파일
		long atchFileId = req.getParameter("atchFileId") == null ? -1
				: Long.parseLong(req.getParameter("atchFileId"));
//		int fileSn = 1;
		int fileSn = req.getParameter("fileSn") == null ? 1
				: Integer.parseInt(req.getParameter("fileSn"));
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		AtchFileDetailVO atchFileDetailVO = new AtchFileDetailVO();
		
		atchFileDetailVO.setAtchFileId(atchFileId);
		atchFileDetailVO.setFileSn(fileSn);
		
		atchFileDetailVO = fileService.getAtchFileDetail(atchFileDetailVO);
		
		/*
		 	Content-Disposition 헤더가 파일 다운로드시 응답메시지의 헤더로 사용되는 경우...
		 	
		 	 Content-Disposition: inline (default) /// inline : 브라우저 내에서 읽는다는 말이다
		 	 Content-Disposition: attachment					 // 파일다운로드(서블릿이름으로)
		 	 Content-Disposition: attachment; filename="abc.jpg" // abc.jpg이름으로 파일 다운로드
		  
		 */
		
		//파일 다운로드 처리를 위한 응답헤더 정보 설정하기
		resp.setContentType("application/octet-stream"); ///공식적으로 마임 데이터를 지원하는 바인드, 어떤 타입인지 몰라도 됨..
//		resp.setContentType("image/jpg"); ///inline
		
		// URL에는 문자를 포함할 수 없다. URLEncoding을 이용하여 인코딩 처리를 하면 (+)로 표시되기 때문에 (+)문자를
		// 공백문자인 %20으로 바꿔서 처리해준다.
		
//		resp.setHeader("Content-Disposition", "attachment"); ///download.do로 다운로드됨
//		resp.setHeader("Content-Disposition", "attachment; filename="+atchFileDetailVO.getOrignlFileNm());
//		resp.setHeader("Content-Disposition", "attachment; filename=\""
////				+ URLEncoder.encode(atchFileDetailVO.getOrignlFileNm(), "UTF-8"+"\"")); ///파일명이 한글일때 인코딩하는거다
//				+ URLEncoder.encode(atchFileDetailVO.getOrignlFileNm(), "UTF-8").replaceAll("\\+", "%20")+"\""); ///파일명이 한글일때 인코딩하는거다
		
		 resp.setHeader("Content-Disposition", "attachment; filename=\"" 
		        + URLEncoder.encode(atchFileDetailVO.getOrignlFileNm(), "UTF-8").replaceAll("\\+", "%20") + "\"");
		 String filePath = atchFileDetailVO.getFileStreCours();
		 String fileNameWithoutExtension = (filePath != null && filePath.contains(".")) ? filePath.substring(0, filePath.lastIndexOf('.')) : filePath;
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(fileNameWithoutExtension));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int data = 0;
		
		while ((data = bis.read()) !=-1) {
			bos.write(data);
		}
		
		bis.close();
		bos.close();
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
