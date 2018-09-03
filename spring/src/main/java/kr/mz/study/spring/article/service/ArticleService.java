package kr.mz.study.spring.article.service;

import java.util.List;

import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.exception.ArticleNotFoundException;
import kr.mz.study.spring.exception.DeleteFailedException;
import kr.mz.study.spring.exception.InsertFailedException;
import kr.mz.study.spring.exception.PageNotFoundException;
import kr.mz.study.spring.exception.UpdateFailedException;

public interface ArticleService {
	
	public List<Article> findArticles(Integer offset, Integer limit) throws PageNotFoundException;
	
	public Article findArticle(Integer idx) throws ArticleNotFoundException;
	
	public int save(Article article) throws InsertFailedException;
	
	public int update(Article article) throws UpdateFailedException;
	
	public int delete(Article article) throws DeleteFailedException;
	
	public boolean selectPassword(Article article);
	
}
