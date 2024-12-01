package kr.or.ddit.bookVideo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BookVideoVO;

public interface IBookVideoService {
	/**
	 * BookVideoVO에 담겨진 소개영상정보를 등록하기 위한 메서드
	 * 
	 * @param bv 소개영상정보를 담은 BookVideoVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨
	 */
	public int registerBookVideo(BookVideoVO bv);

	/**
	 * BookVideoVO에 담겨진 소개영상정보를 수정하기 위한 메서드
	 * 
	 * @param bv 소개영상정보를 담은 BookVideoVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨.
	 */
	public int modifyBookVideo(BookVideoVO bv);

	/**
	 * 해당소개영상이 존재여부를 확인하기위한 메서드
	 * 
	 * @param bookVideoNo 존재여부 확인하기위한 소개영상ID
	 * @return 해당소개영상이 존재하면 true, 존재하지 않으면 false 리턴함
	 */

	public boolean checkBookVideo(String bookVideoNo);

	/**
	 * 해당 소개영상의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param bookVideoNo 상세정보를 조회할 소개영상 ID
	 * @return 해당 소개영상의 상세정보를 담은 BookVideoVO 객체 리턴함
	 */
	public BookVideoVO getBookVideo(String bookVideoNo);

	/**
	 * 해당 소개영상정보를 삭제하기위한 메서드
	 * 
	 * @param bookVideoNo 삭제하고자 하는 소개영상ID
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */

	public int removeBookVideo(String bookVideoNo);

	/**
	 * 모든 소개영상정보를 가져오기위한 메서드
	 * 
	 * @return 모든 소개영상정보를 담은 List객체
	 */
	public List<BookVideoVO> getTotalBookVideo();

	/**
	 * 소개영상정보를 검색하기 위한 메서드
	 * 
	 * @param bv 검색할 소개영상정보를 담은 BookVideoVO객체
	 * @return 검색된 소개영상정보를 담은 List 객체
	 */
	public List<BookVideoVO> searchBookVideo(BookVideoVO bv);
	
	/**
	 * 페이징처리를 위한 전체게시글 개수 찾기 위한 메서드
	 * @return 전체 게시글 수
	 */
	public int countList();

	/**
	 * 페이징처리를 위한 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 게시글들
	 */
	public List<BookVideoVO> boardList(Map<String, Object> map);
	
}
