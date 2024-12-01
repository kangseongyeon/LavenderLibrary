package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {

	/**
	 * NoticeVO에 담겨진 공지정보를 등록하기 위한 메서드
	 * 
	 * @param nv 공지정보를 담은 NoticeVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨
	 */
	public int registerNotice(NoticeVO nv);

	/**
	 * NoticeVO에 담겨진 공지정보를 수정하기 위한 메서드
	 * 
	 * @param nv 공지정보를 담은 NoticeVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨.
	 */
	public int modifyNotice(NoticeVO nv);

	/**
	 * 해당공지이 존재여부를 확인하기위한 메서드
	 * 
	 * @param noticeNo 존재여부 확인하기위한 공지ID
	 * @return 해당공지이 존재하면 true, 존재하지 않으면 false 리턴함
	 */

	public boolean checkNotice(String noticeNo);

	/**
	 * 해당 공지의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param noticeNo 상세정보를 조회할 공지 ID
	 * @return 해당 공지의 상세정보를 담은 NoticeVO 객체 리턴함
	 */
	public NoticeVO getNotice(String noticeNo);

	/**
	 * 해당 공지정보를 삭제하기위한 메서드
	 * 
	 * @param noticeNo 삭제하고자 하는 공지ID
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */

	public int removeNotice(String noticeNo);

	/**
	 * 모든 공지정보를 가져오기위한 메서드
	 * 
	 * @return 모든 공지정보를 담은 List객체
	 */
	public List<NoticeVO> getTotalNotice();
	
	/**
	 * DB에 존재하는 공지정보중 고정된(pin=1) 정보를 가져오기위한 메서드
	 * 
	 * @return 고정된 공지정보를 담은 List객체
	 */
	public List<NoticeVO> selectPinNotice();

	/**
	 * 공지정보를 검색하기 위한 메서드
	 * 
	 * @param nv 검색할 공지정보를 담은 NoticeVO객체
	 * @return 검색된 공지정보를 담은 List 객체
	 */
	public List<NoticeVO> searchNotice(NoticeVO nv);
	
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
	public List<NoticeVO> boardList(Map<String, Object> map);
	
	

}
