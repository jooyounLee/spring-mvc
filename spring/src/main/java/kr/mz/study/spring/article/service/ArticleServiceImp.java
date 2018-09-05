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

@Service("articleService")
public class ArticleServiceImp implements ArticleService{

	@Resource(name = "articleDAO")
	private ArticleRepository dao;
	
	/**
	 * 전체 글 count
	 */
	@Override
	public int findCountAll() {
		return dao.selectCount();
	}
	
	/**
	 * 리스트 get
	 * @param pageParam
	 * @return Map
	 * @throws PageNotFoundException 
	 */
	@Override
	public List<Article> findArticles(Integer offset, Integer limit){
		Map<String, Object> pageInfo = new HashMap<>();
		
		pageInfo.put("firstPost", offset);
		pageInfo.put("countPostPerPage", limit);
		
		return dao.selectArticles(pageInfo);
	}
	
	/**
	 * 글 읽기
	 * @param idx
	 * @return Article
	 * @throws ArticleNotFoundException 
	 */
	@Override
	public Article findArticle(Integer idx){
		return dao.select(idx);
	}

	/**
	 * 글 저장
	 * @param article
	 * @return int
	 * @throws InsertFailedException 
	 */
	@Override
	public int save(Article article){
		return dao.insert(article);
	}

	/**
	 * 글 수정
	 * @param article
	 * @return int
	 * @throws InsertFailedException 
	 */
	@Override
	public int update(Article article){
		return dao.update(article);
	}
	
	/**
	 * 글 삭제
	 * @param idx
	 * @param password
	 * @return boolean
	 * @throws DeleteFailedException 
	 */
	@Override
	public int delete(Article article){
		return dao.delete(article);
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
