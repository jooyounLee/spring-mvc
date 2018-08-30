package kr.mz.study.spring.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import kr.mz.study.spring.article.dao.ArticleRepository;
import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.exception.ArticleNotFoundException;
import kr.mz.study.spring.exception.DeleteFailedException;
import kr.mz.study.spring.exception.InsertFailedException;
import kr.mz.study.spring.exception.PageNotFoundException;
import kr.mz.study.spring.exception.UpdateFailedException;

@Service("articleService")
public class ArticleService {

	@Resource(name = "articleDAO")
	private ArticleRepository dao;
	
	
	/**
	 * 리스트 get
	 * @param pageParam
	 * @return Map
	 * @throws PageNotFoundException 
	 */
	public Map<String, Object> findArticles(Integer pageParam) throws PageNotFoundException {
		
		// 전체 글 수--
		int totalPostCount = dao.selectCount();
		
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
		
		Map<String, Object> pageInfo = new HashMap<>();
		pageInfo.put("firstPost", firstPost);
		pageInfo.put("countPostPerPage", countPostPerPage);
	
		List<Article> articles = dao.selectArticles(pageInfo);
		
		if(articles.size() <= 0) {
			throw new PageNotFoundException(pageParam);
		}
		
		Map<String, Object> articlesAndPages = new HashMap<>();
		articlesAndPages.put("articles", articles);
		articlesAndPages.put("totalPostCount", totalPostCount);
		articlesAndPages.put("countPostPerPage", countPostPerPage);
		articlesAndPages.put("selectPageNum", selectPageNum);
		
		return articlesAndPages;
	}
	
	/**
	 * 글 읽기
	 * @param idx
	 * @return Article
	 * @throws ArticleNotFoundException 
	 */
	public Article findArticle(Integer idx) throws ArticleNotFoundException {
		Assert.notNull(idx, "'idx' parameter is required.");

		Article article = dao.select(idx);
		
		if(article == null) {
			throw new ArticleNotFoundException(idx);
		}
		
		return article;
	}

	/**
	 * 글 저장
	 * @param article
	 * @return int
	 * @throws InsertFailedException 
	 */
	public int save(Article article) throws InsertFailedException {

		int insertResult = dao.insert(article);

		if(insertResult < 1) {
			throw new InsertFailedException();
		}
		
		return insertResult;
	}

	/**
	 * 글 수정
	 * @param article
	 * @return int
	 * @throws InsertFailedException 
	 */
	public int update(Article article) throws UpdateFailedException {

		int updateResult = dao.update(article);

		if(updateResult < 1) {
			throw new UpdateFailedException();
		}
		
		return updateResult;
	}
	
	/**
	 * 글 삭제
	 * @param idx
	 * @param password
	 * @return boolean
	 * @throws DeleteFailedException 
	 */
	public int delete(Article article) throws DeleteFailedException {
	
		int deleteResult = dao.delete(article);

		if(deleteResult < 1) {
			throw new DeleteFailedException();
		}
		
		return deleteResult;
	}
	
	/**
	 * 비밀번호 확인
	 * @param idx
	 * @param password
	 * @return boolean
	 */
	public boolean selectPassword(Article article) {
		Assert.notNull(article.getIdx(), "'idx' parameter is required.");
		Assert.notNull(article.getPassword(), "'password' parameter is required.");

		String originPassword = dao.selectPassword(article.getIdx());
		
		return article.getPassword().equals(originPassword);
	}

}
