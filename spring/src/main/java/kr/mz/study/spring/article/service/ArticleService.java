package kr.mz.study.spring.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import kr.mz.study.spring.article.dao.ArticleDAO;
import kr.mz.study.spring.article.model.Article;

@Service("articleService")
public class ArticleService {

	@Resource(name = "articleDAO")
	private ArticleDAO dao;

	
	
	/**
	 * 리스트 get
	 * @param pageParam
	 * @return Map
	 */
	public Map<String, Object> getArticles(Integer pageParam) {
		
		// 전체 글 수--
		int totalPostCount = dao.getListCount();
		
		// 한 페이지당 글 수--
		int countPostPerPage = 6;
		
		// page parameter
		int selectPageNum = 1;
		if(pageParam != null) {
			selectPageNum = pageParam;
		}	
		
		// 페이지 첫번째 글
		int firstPost = countPostPerPage * (selectPageNum - 1);
		if(firstPost < 0) {
			firstPost = 0;
		}
		
		Map<String, Object> articlesAndPageinfo = new HashMap<>();
	
		List<Article> articles = dao.getArticleList(firstPost, countPostPerPage);
		
		articlesAndPageinfo.put("articles", articles);
		articlesAndPageinfo.put("totalPostCount", totalPostCount);
		articlesAndPageinfo.put("countPostPerPage", countPostPerPage);
		articlesAndPageinfo.put("selectPageNum", selectPageNum);
		
		return articlesAndPageinfo;
	}
	
	/**
	 * 글 읽기
	 * @param idx
	 * @return Article
	 */
	public Article getArticleDetail(Integer idx) {
		Assert.notNull(idx, "'idx' parameter is required.");
		
		Article article = dao.getArticleDetail(idx);

		return article;
	}

	/**
	 * 글 작성
	 * @param password
	 * @param title
	 * @param userName
	 * @param content
	 * @return int
	 */
	public int createArticle(String password, String title, String userName, String content) {

		Article article = new Article();
		article.setPassword(password);
		article.setTitle(title);
		article.setUserName(userName);
		article.setContent(content);
		
		int createResult = dao.createArticle(article);

		return createResult;
	}

	/**
	 * 글 수정
	 * @param password
	 * @param title
	 * @param userName
	 * @param content
	 * @param idx
	 * @return int
	 */
	public boolean updateArticle(String password, String title, String userName, String content, Integer idx) {
		
		Article article = new Article();
		article.setIdx(idx);
		article.setPassword(password);
		article.setTitle(title);
		article.setUserName(userName);
		article.setContent(content);
		
		int updateResult = dao.modifyArticle(article);
		
		return (updateResult > 0) ? true : false;
	}
	
	/**
	 * 글 삭제
	 * @param idx
	 * @param password
	 * @return boolean
	 */
	public boolean deleteArticle(Integer idx, String password) {
		
		int deleteResult = dao.deleteArticle(idx);
		
		return (deleteResult > 0) ? true : false;
	}
	
	/**
	 * 비밀번호 확인
	 * @param idx
	 * @param password
	 * @return boolean
	 */
	public boolean isCorrectPassword(Integer idx, String password) {
		Assert.notNull(idx, "'idx' parameter is required.");
		Assert.notNull(password, "'password' parameter is required.");
		
		String originPassword = dao.checkPassword(idx);
		
		return password.equals(originPassword);
	}

}
