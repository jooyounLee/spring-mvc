package kr.mz.study.spring.article.service;

import java.util.List;

import kr.mz.study.spring.article.model.Article;

public interface ArticleService {
	
	public List<Article> findArticles(Integer offset, Integer limit);
	
	public Article findArticle(Integer idx);
	
	public int save(Article article);
	
	public int update(Article article);
	
	public int delete(Article article);
	
	public boolean selectPassword(Article article);
	
	public int findCountAll();
	
}
