package kr.mz.study.spring.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.mz.study.spring.article.dao.ArticleRepository;
import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.exception.ArticleNotFoundException;
import kr.mz.study.spring.exception.DeleteFailedException;
import kr.mz.study.spring.exception.InsertFailedException;
import kr.mz.study.spring.exception.PageNotFoundException;
import kr.mz.study.spring.exception.UpdateFailedException;

@Service("articleService")
public class ArticleServiceImp implements ArticleService{

	@Resource(name = "articleDAO")
	private ArticleRepository dao;
	
	
	/**
	 * 리스트 get
	 * @param pageParam
	 * @return Map
	 * @throws PageNotFoundException 
	 */
	@Override
	public List<Article> findArticles(Integer offset, Integer limit) throws PageNotFoundException {
		Map<String, Object> pageInfo = new HashMap<>();
		
		pageInfo.put("firstPost", offset);
		pageInfo.put("countPostPerPage", limit);
	
		List<Article> articles = dao.selectArticles(pageInfo);
		
		if(articles.size() <= 0) {
			throw new PageNotFoundException(offset);
		}
		
		return articles;
	}
	
	
	/**
	 * 글 읽기
	 * @param idx
	 * @return Article
	 * @throws ArticleNotFoundException 
	 */
	@Override
	public Article findArticle(Integer idx) throws ArticleNotFoundException {
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
	@Override
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
	@Override
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
	@Override
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
		String originPassword = dao.selectPassword(article.getIdx());
		return article.getPassword().equals(originPassword);
	}

}
