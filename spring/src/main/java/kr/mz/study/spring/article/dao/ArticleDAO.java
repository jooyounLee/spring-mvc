package kr.mz.study.spring.article.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.mz.study.spring.article.model.Article;

@Repository("articleDAO")
public class ArticleDAO {
	
	// TODO : 2018.08.25  
	// @Autowired sqlSession : get DB Connections 
	// SqlSession.insert("namespace.id", Article) : Connect Mapper (SQL)
	// .update .delete .selectOne .selectList
	// Mapper -> resultType = Article / parameterType = none
	
	@Autowired private SqlSession sqlSession;
	
	public int getListCount() {
		int count = sqlSession.selectOne("articleSql.getListCount");
		
		return count;
	};
	
	/**
	 * 게시판 리스트
	 * @return ArrayList
	 */
	public List<Article> getArticleList(Integer firstPost, Integer countPostPerPage){
		
		List<Article> articles = new ArrayList<>();
		Map<String, Object> limits = new HashMap<>();
		
		limits.put("firstPost", firstPost);
		limits.put("countPostPerPage", countPostPerPage);
		
		articles = sqlSession.selectList("articleSql.getArticleList", limits);
		
		return articles;
	};
	
	/**
	 * 게시판 글상세보기
	 * @param idx
	 * @return DTO
	 */
	public Article getArticleDetail(Integer idx) {
		Article article = new Article();
		
		article = sqlSession.selectOne("articleSql.getArticleDetail", idx);
		return article;
	};
	
	/**
	 * 게시판 글쓰기
	 * @param title
	 * @param userName
	 * @param content
	 * @return int
	 */
	public int createArticle(Article article) {
		
		int createResult = sqlSession.insert("articleSql.createArticle", article);
		return createResult;
	};
	
	/**
	 * 게시글 수정
	 * @param userName
	 * @param title
	 * @param content
	 * @param idx
	 * @return int
	 */
	public int modifyArticle(Article article) {
		
		int modifyResult = sqlSession.update("articleSql.modifyArticle", article);
		return modifyResult;
	};
	
	/**
	 * 게시글 삭제(deleted:1로 update)
	 * @param idx
	 * @return int
	 */
	public int deleteArticle(Integer idx) {
		
		return sqlSession.update("articleSql.deleteArticle", idx);
	};
	
	/**
	 * 비밀번호 확인
	 * @param password
	 * @param idx
	 * @return int
	 */
	public String checkPassword(Integer idx) {
	
		return sqlSession.selectOne("articleSql.checkPassword", idx);
	};
}
