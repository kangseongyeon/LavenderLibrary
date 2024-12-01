package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;





public class MemberServiceImpl implements IMemberService{

	private static IMemberService service;
	private IMemberDao dao;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	
	@Override
	public int joinMem(MemberVO memVO) {
		
		int cnt = dao.joinMem(memVO);
		return cnt;
	}

	@Override
	public MemberVO loginChk(Map<String, Object> map) {
		
		MemberVO mv = null;
		try {
			mv = dao.loginChk(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
		
	}

	@Override
	public String FindId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.FindId(map);
	}

	@Override
	public String FindPw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.FindPw(map);
	}
	
	@Override
	public MemberVO memInfo(String memId) {
		// TODO Auto-generated method stub
		return dao.memInfo(memId);
	}

	@Override
	public int updateMember(MemberVO memVO) {
		// TODO Auto-generated method stub
		return dao.updateMember(memVO);
	}

	@Override
	public int updatePassword(MemberVO mv) {
		int cnt = dao.updatePassword(mv);
		return cnt;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public List<MemberVO> getBlacklist() {
		return dao.getBlacklist();
	}

	@Override
	public int insertBlacklist(String memId) {
		return dao.insertBlacklist(memId);
	}

	@Override
	public int deleteBlacklist(String memId) {
		return dao.deleteBlacklist(memId);
	}

	@Override
	public int updateWarn() {
		return dao.updateWarn();
	}

	@Override
	public int resetWarn() {
		return dao.resetWarn();
	}

	@Override
	public List<MemberVO> getRevMemList(String bookId) {
		return dao.getRevMemList(bookId);
	}

	@Override
	public int plusMemWarn(String memId) {
		return dao.plusMemWarn(memId);
	}

	@Override
	public int minusMemWarn(String memId) {
		return dao.minusMemWarn(memId);
	}

	@Override
	public int countList() {
		return dao.countList();
	}

	@Override
	public List<MemberVO> boardList(Map<String, Object> map) {
		return dao.boardList(map);
	}
	
	   @Override
	   public int blacklistCountList() {
	      // TODO Auto-generated method stub
	      return dao.blacklistCountList();
	   }

	   @Override
	   public List<MemberVO> blacklistBoardList(Map<String, Object> map) {
	      // TODO Auto-generated method stub
	      return dao.blacklistBoardList(map);
	   }

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteMember(memId);
	}

	@Override
	public int resetMemWarn(String memId) {
		return dao.resetMemWarn(memId);
	}


}
