//package kr.or.ddit.book.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/uploads/*")
//public class DownloadServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private static final String UPLOAD_DIR = "C:/upload";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String fileName = req.getPathInfo().substring(1); // 파일 이름 추출
//        File file = new File(UPLOAD_DIR, fileName);
//
//        System.out.println("실행");
//        if (file.exists()) {
//            resp.setContentType("application/octet-stream");
//            resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
//            try (FileInputStream in = new FileInputStream(file); OutputStream out = resp.getOutputStream()) {
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = in.read(buffer)) != -1) {
//                    out.write(buffer, 0, bytesRead);
//                }
//            }
//        } else {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
//}
