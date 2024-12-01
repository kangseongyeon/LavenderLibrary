package kr.or.ddit.inquiry.service;

import java.util.List;

import kr.or.ddit.inquiry.dao.IInqCategoryDao;
import kr.or.ddit.inquiry.dao.InqCategoryDaoImpl;
import kr.or.ddit.vo.InqCategoryVO;

public class InqCategoryServiceImpl implements IInqCategoryService {
    private static IInqCategoryService inqCategoryService = new InqCategoryServiceImpl();

    private IInqCategoryDao inqCategoryDao;

    private InqCategoryServiceImpl() {
        inqCategoryDao = InqCategoryDaoImpl.getInstance();
    }

    public static IInqCategoryService getInstance() {
        return inqCategoryService;
    }

    @Override
    public List<InqCategoryVO> getTotalCategories() {
        return inqCategoryDao.getAllCategories();
    }
}
