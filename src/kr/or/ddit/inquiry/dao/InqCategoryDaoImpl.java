package kr.or.ddit.inquiry.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.InqCategoryVO;

public class InqCategoryDaoImpl implements IInqCategoryDao {
    private static IInqCategoryDao inqCategoryDao = new InqCategoryDaoImpl();
    
    private InqCategoryDaoImpl() {
    }
    
    public static IInqCategoryDao getInstance() {
        return inqCategoryDao;
    }
    
    @Override
    public List<InqCategoryVO> getAllCategories() {
        List<InqCategoryVO> inqCategoryList = new ArrayList<>();
        
        SqlSession session = MyBatisUtil.getSQLSession(true);

        try {
            inqCategoryList = session.selectList("inqCategory.selectAllCategories");
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return inqCategoryList;
    }
}
