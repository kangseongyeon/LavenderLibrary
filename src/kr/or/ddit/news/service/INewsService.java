package kr.or.ddit.news.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NewsVO;

public interface INewsService {
	/**
	 * NewsVO에 담겨진 소식지 정보를 등록하기 위한 메서드
	 * 
	 * @param nv 소식지 정보를 담은 NewsVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨
	 */
	public int registerNews(NewsVO nv);

	/**
	 * NewsVO에 담겨진 소식지 정보를 수정하기 위한 메서드
	 * 
	 * @param nv 소식지 정보를 담은 NewsVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨.
	 */
	public int modifyNews(NewsVO nv);

	/**
	 * 해당 소식지 존재여부를 확인하기위한 메서드
	 * 
	 * @param newsNo 존재여부 확인하기위한 소식지ID
	 * @return 해당소식지이 존재하면 true, 존재하지 않으면 false 리턴함
	 */

	public boolean checkNews(String newsNo);

	/**
	 * 해당 소식지의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param newsNo 상세정보를 조회할 소식지 ID
	 * @return 해당 소식지의 상세정보를 담은 NewsVO 객체 리턴함
	 */
	public NewsVO getNews(String newsNo);

	/**
	 * 해당 소식지 정보를 삭제하기위한 메서드
	 * 
	 * @param newsNo 삭제하고자 하는 소식지ID
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */

	public int removeNews(String newsNo);

	/**
	 * 모든 소식지 정보를 가져오기위한 메서드
	 * 
	 * @return 모든 소식지 정보를 담은 List객체
	 */
	public List<NewsVO> getTotalNews();

	/**
	 * 소식지 정보를 검색하기 위한 메서드
	 * 
	 * @param nv 검색할 소식지 정보를 담은 NewsVO객체
	 * @return 검색된 소식지 정보를 담은 List 객체
	 */
	public List<NewsVO> searchNews(NewsVO nv);
	
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
	public List<NewsVO> boardList(Map<String, Object> map);
	
	
}
