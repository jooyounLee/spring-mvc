package kr.mz.study.spring.article.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.mz.study.spring.article.model.Article;

@Repository("articleDAO")
public class ArticleRepository {
	
	@Autowired private SqlSession sqlSession;
	
	public int selectCount() {
		
		return sqlSession.selectOne("article.selectCount");
	};
	
	/**
	 * 게시판 리스트
	 * @param firstPost
	 * @param countPostPerPage
	 * @return List
	 */
	public List<Article> selectArticles(Map<String, Object> pageInfo){
		
		return sqlSession.selectList("article.selectArticles", pageInfo);
	};
	
	/**
	 * 게시판 글상세보기
	 * @param idx
	 * @return Article
	 */
	public Article select(Integer idx) {
		
		return sqlSession.selectOne("article.select", idx);
	};
	
	/**
	 * 게시판 글쓰기
	 * @param Article
	 * @return int
	 */
	public int insert(Article article) {
		
		return sqlSession.insert("article.insert", article);
	};
	
	/**
	 * 게시글 수정
	 * @param Article
	 * @return int
	 */
	public int update(Article article) {
		
		return sqlSession.update("article.update", article);
	};
	
	/**
	 * 게시글 삭제
	 * @param idx
	 * @return int
	 */
	public int delete(Article article) {
	
		return sqlSession.update("article.delete", article);
	};
	
	/**
	 * 비밀번호 확인
	 * @param password
	 * @param idx
	 * @return String
	 */
	public String selectPassword(Integer idx) {
	
		return sqlSession.selectOne("article.selectPassword", idx);
	};
}
