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
	 * @param articlePw
	 * @param title
	 * @param userNm
	 * @param content
	 * @return int
	 */
	public int createArticle(String articlePw, String title, String userNm, String content) {

		int createResult = dao.createArticle(articlePw, title, userNm, content);

		return createResult;
	}

	/**
	 * 글 수정
	 * @param articlePw
	 * @param title
	 * @param userNm
	 * @param content
	 * @param idx
	 * @return int
	 */
	public boolean updateArticle(String articlePw, String title, String userNm, String content, Integer idx) {
		
		int updateResult = dao.modifyArticle(userNm, articlePw, title, content, idx);
		
		return (updateResult > 0) ? true : false;
	}
	
	/**
	 * 글 삭제
	 * @param idx
	 * @param articlePw
	 * @return boolean
	 */
	public boolean deleteArticle(Integer idx, String articlePw) {
		
		int deleteResult = dao.deleteArticle(idx);
		
		return (deleteResult > 0) ? true : false;
	}
	
	/**
	 * 비밀번호 확인
	 * @param idx
	 * @param articlePw
	 * @return boolean
	 */
	public boolean isCorrectPassword(Integer idx, String articlePw) {
		Assert.notNull(idx, "'idx' parameter is required.");
		Assert.notNull(articlePw, "'articlePw' parameter is required.");

		String originPassword = dao.checkPassword(idx);
		return articlePw.equals(originPassword);
	}

}
