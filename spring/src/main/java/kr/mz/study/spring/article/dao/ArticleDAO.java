package kr.mz.study.spring.article.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.mz.study.spring.article.model.Article;

@Repository("articleDAO")
public class ArticleDAO {
	
	@Autowired private SqlSession sqlSession;
	
	public int selectCount() {
		
		return sqlSession.selectOne("articleSql.selectCount");
	};
	
	/**
	 * 게시판 리스트
	 * @param firstPost
	 * @param countPostPerPage
	 * @return List
	 */
	public List<Article> selectArticles(Map<String, Object> pageInfo){
		
		return sqlSession.selectList("articleSql.selectArticles", pageInfo);
	};
	
	/**
	 * 게시판 글상세보기
	 * @param idx
	 * @return Article
	 */
	public Article selectArticle(Integer idx) {
		
		return sqlSession.selectOne("articleSql.selectArticle", idx);
	};
	
	/**
	 * 게시판 글쓰기
	 * @param Article
	 * @return int
	 */
	public int insertArticle(Article article) {
		
		return sqlSession.insert("articleSql.insertArticle", article);
	};
	
	/**
	 * 게시글 수정
	 * @param Article
	 * @return int
	 */
	public int updateArticle(Article article) {
		
		return sqlSession.update("articleSql.updateArticle", article);
	};
	
	/**
	 * 게시글 삭제
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
	 * @return String
	 */
	public String selectPassword(Integer idx) {
	
		return sqlSession.selectOne("articleSql.selectPassword", idx);
	};
}
