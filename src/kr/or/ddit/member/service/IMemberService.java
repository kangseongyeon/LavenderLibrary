package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;



public interface IMemberService {
	
	
	//회원가입처리
	public int joinMem(MemberVO memVO);

	//로그인 id-pw 검증
	public MemberVO loginChk(Map<String, Object> map);
	
	//아이디 찾기 - 전화번호 /이메일
	public String FindId(Map<String, Object> map);
	
	//비밀번호 찾기 - 이름 / 아이디 / 생년월일 / 이메일 --> 이메일로 인증 받아 비밀번호를 메일로 전달
	public String FindPw(Map<String, Object> map);

	//회원정보 불러오기
	public MemberVO memInfo(String memId);
	
	//회원정보 수정하기
	public int updateMember(MemberVO memVO);
	
	//임시비번으로 업데이트
	public int updatePassword(MemberVO mv);
	
	//회원목록 출력(관리자용)
	public List<MemberVO> getAllMember();
	
	//블랙리스트 목록 출력(관리자용)
	public List<MemberVO> getBlacklist();

	//회원 블랙리스트 추가
	public int insertBlacklist(String memId);
	
	//회원 블랙리스트 제거(update)
	public int deleteBlacklist(String memId);
	
	//회원 경고 횟수 초기화
			public int resetMemWarn(String memId);
	
	//전체 회원 경고 추가 및 블랙리스트 추가
	public int updateWarn();
	
	//전체 회원 경고 횟수 해 지날때 초기화
	public int resetWarn();
	
	//도서에 따른 회원목록 조회
	public List<MemberVO> getRevMemList(String bookId);
	
	//회원 경고 추가
	public int plusMemWarn(String memId);
	
	//회원 경고 추가
	public int minusMemWarn(String memId);
	
	// 회원 탈퇴
	public int deleteMember(String memId);
	
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
	public List<MemberVO> boardList(Map<String, Object> map);
	
	   /**
	    * 페이징처리를 위한 전체 블랙리스트 회원수  찾기 위한 메서드
	    * @return 전체 게시글 수
	    */
	   public int blacklistCountList();

	   /**
	    * 페이징처리를 위한 블랙리스트회원 가져오는 메소드
	    * @param map
	    * @return 원하는 개수만큼의 게시글들
	    */
	   public List<MemberVO> blacklistBoardList(Map<String, Object> map);
	
	
}
