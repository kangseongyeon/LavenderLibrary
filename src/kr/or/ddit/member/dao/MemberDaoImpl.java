package kr.or.ddit.member.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.book.vo.ReservVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.MyBatisUtil;

public class MemberDaoImpl implements IMemberDao {

	private static MemberDaoImpl dao;

	// 싱글톤
	// 1.private constructor
	private MemberDaoImpl() {

	}

	// 2.static method
	public static IMemberDao getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public int joinMem(MemberVO MV) {

		SqlSession session = MyBatisUtil.getSQLSession(false);

		int cnt = 0;

		try {
			cnt = session.insert("member.joinMem", MV);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public MemberVO loginChk(Map<String, Object> map) {

		SqlSession session = MyBatisUtil.getSQLSession(true);

		MemberVO mv = null;

		try {
			mv = session.selectOne("member.loginChk", map);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생", e);
		} finally {
			session.close();
		}

		return mv;

	}

	@Override
	public String FindId(Map<String, Object> map) {
		SqlSession session = MyBatisUtil.getSQLSession(true);

		String memId = null;

		try {
			memId = session.selectOne("member.findId", map);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생", e);
		} finally {
			session.close();
		}

		return memId;
	}

	@Override
	public String FindPw(Map<String, Object> map) {
		SqlSession session = MyBatisUtil.getSQLSession(true);

		String memPw = null;

		try {
			memPw = session.selectOne("member.findPw", map);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생", e);
		} finally {
			session.close();
		}

		return memPw;
	}

	// 회원정보 전체 불러오기 0710
	@Override
	public MemberVO memInfo(String memId) {

		MemberVO mv = null;

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			mv = session.selectOne("member.memInfo", memId);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return mv;
	}

	@Override
	public int updateMember(MemberVO memVO) {
		SqlSession session = MyBatisUtil.getSQLSession();

		int cnt = 0;

		try {
			cnt = session.update("member.updateMember", memVO);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int updatePassword(MemberVO mv) {

		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.updatePassword", mv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			memList = session.selectList("member.getAllMember");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return memList;
	}

	@Override
	public List<MemberVO> getBlacklist() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			memList = session.selectList("member.getBlacklist");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return memList;
	}

	@Override
	public int insertBlacklist(String memId) {

		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.insertBlacklist", memId);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int deleteBlacklist(String memId) {

		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.deleteBlacklist", memId);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int updateWarn() {
		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.updateWarn");

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int resetWarn() {
		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.resetWarn");

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getRevMemList(String bookId) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			memList = session.selectList("member.getRevMemList", bookId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return memList;
	}

	@Override
	public int plusMemWarn(String memId) {
		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.plusMemWarn", memId);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int minusMemWarn(String memId) {
		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.minusMemWarn", memId);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int countList() {
		int cnt = 0;
		SqlSession session = MyBatisUtil.getSQLSession();

		try {
			cnt = session.selectOne("member.countList");

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생", e);
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> boardList(Map<String, Object> map) {
		List<MemberVO> list = null;

		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("member.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생", e);
		} finally {
			session.close();
		}
		return list;
	}
	
	   @Override
	   public int blacklistCountList() {
	      int cnt  = 0;
	      SqlSession session = MyBatisUtil.getSQLSession();
	      
	      try {
	         cnt = session.selectOne("member.blacklistCountList");
	         
	      } catch (PersistenceException e) {
	         throw new RuntimeException("데이터 조회 중 예외 발생",e);
	      } finally {
	         session.close();
	      }
	      
	      return cnt;
	   }
	
	   @Override
	   public List<MemberVO> blacklistBoardList(Map<String, Object> map) {
	      List<MemberVO> list= null;
	      
	      SqlSession session = MyBatisUtil.getSQLSession();
	      try {
	         list = session.selectList("member.blacklistBoardList", map);
	      } catch (Exception e) {
	         throw new RuntimeException("데이터 조회 중 예외 발생",e); 
	      } finally{
	         session.close();
	      }         
	      return list;
	   }

	@Override
	public int deleteMember(String memId) {
		SqlSession session = MyBatisUtil.getSQLSession(false); // 디폴트값 false

		int cnt = 0;
		try {
			cnt = session.update("member.deleteMember", memId);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int resetMemWarn(String memId) {
		SqlSession session = MyBatisUtil.getSQLSession();

		int cnt = 0;

		try {
			cnt = session.update("member.resetMemWarn", memId);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}
	

}
