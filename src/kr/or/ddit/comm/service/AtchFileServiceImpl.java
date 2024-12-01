package kr.or.ddit.comm.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.Part;

import kr.or.ddit.comm.dao.AtchFileDaoImpl;
import kr.or.ddit.comm.dao.IAtchFileDao;
import kr.or.ddit.comm.vo.AtchFileDetailVO;
import kr.or.ddit.comm.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService{

private static IAtchFileService fileService = new AtchFileServiceImpl();///
	
	
	private IAtchFileDao fileDao;
	
	public AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		return fileService;
	}///
	


	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) {
		

		String uploadPath = "c://upload";
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		AtchFileVO atchFileVO = null;
		
		boolean isFirstFile = true; //첫번째 파일 여부...
		
		for (Part part : parts) {
			
			String fileName = part.getSubmittedFileName(); // 업로드 파일명 추출
			
			if(fileName != null && !fileName.equals("")) {

				if(isFirstFile) { //첫번째 업로드파일인지 체크 
					
					isFirstFile = false;
					
					atchFileVO = new AtchFileVO();
					
					fileDao.insertAtchFile(atchFileVO); // ATCH_FILE에 insert 하기
					
					
				}
				
				long fileSize = part.getSize(); //파일크기
				String saveFileName = UUID.randomUUID().toString().replace("-", ""); //저장파일명
				String saveFilePath = uploadPath+"/"+saveFileName; //저장 파일경로
				
				// 확장자 추출
				String fileExtension = fileName.lastIndexOf(".") < 0? ""
						: fileName.substring(fileName.lastIndexOf(".")+1);
				
				try {
					// 업로드파일 저장하기
					if(fileExtension.equals("png")||fileExtension.equals("jpg")||fileExtension.equals("jpeg")||fileExtension.equals("webp")) {
						part.write(saveFilePath+"."+fileExtension);
					}else part.write(saveFilePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				AtchFileDetailVO atchFileDetailVO = new AtchFileDetailVO();
				atchFileDetailVO.setAtchFileId(atchFileVO.getAtchFileId());
				atchFileDetailVO.setStreFileNm(saveFileName);
				atchFileDetailVO.setFileSize(fileSize);
				atchFileDetailVO.setOrignlFileNm(fileName);
				atchFileDetailVO.setFileStreCours(saveFilePath);///파일 저장경로
				atchFileDetailVO.setFileExtsn(fileExtension);
				atchFileDetailVO.setImgName(saveFileName+"."+fileExtension);
				
				
				
				fileDao.insertAtchFileDetail(atchFileDetailVO); //파일 세부정보 저장
				
				try {
					// 임시 업로드 파일 삭제처리 하기
					part.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return atchFileVO;
	}

	@Override
	public AtchFileVO getAtchFile(AtchFileVO fileVO) {
		return fileDao.getAtchFile(fileVO);
	}

	@Override
	public AtchFileDetailVO getAtchFileDetail(AtchFileDetailVO athAtchFileDetailVO) {
		return fileDao.getAtchFileDetail(athAtchFileDetailVO);
	}
}
