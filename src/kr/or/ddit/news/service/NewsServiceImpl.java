package kr.or.ddit.news.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.news.dao.INewsDao;
import kr.or.ddit.news.dao.NewsDaoImpl;
import kr.or.ddit.vo.NewsVO;

public class NewsServiceImpl implements INewsService{
	private static INewsService newsService = new NewsServiceImpl();
	
	private INewsDao newsDao;
	
	private NewsServiceImpl() {
		newsDao = NewsDaoImpl.getInstance();
	}
	
	public static INewsService getInstance() {
		return newsService;
	}

	@Override
	public int registerNews(NewsVO nv) {
		int cnt = newsDao.insertNews(nv);
		return cnt;
	}

	@Override
	public int modifyNews(NewsVO nv) {
		int cnt = newsDao.updateNews(nv);
		return cnt;
	}

	@Override
	public boolean checkNews(String newsNo) {
		return newsDao.checkNews(newsNo);
	}

	@Override
	public NewsVO getNews(String newsNo) {
		return newsDao.getNews(newsNo);
	}

	@Override
	public int removeNews(String newsNo) {
		int cnt = newsDao.deleteNews(newsNo);
		return cnt;
	}

	@Override
	public List<NewsVO> getTotalNews() {
		List<NewsVO> newsList = newsDao.getAllNews();
		return newsList;
	}

	@Override
	public List<NewsVO> searchNews(NewsVO nv) {
		return newsDao.searchNews(nv);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return newsDao.countList();
	}

	@Override
	public List<NewsVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsDao.boardList(map);
	}
	
	
}
