package kr.mz.study.spring.article.dao;

import java.util.ArrayList;
import java.util.List;

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
		return 0;
	};
	
	/**
	 * 게시판 리스트
	 * @return ArrayList
	 */
	public List<Article> getArticleList(Integer firstPost, Integer countPostPerPage){
		List<Article> list = new ArrayList<>();
		return list;
	};
	
	/**
	 * 게시판 글상세보기
	 * @param idx
	 * @return DTO
	 */
	public Article getArticleDetail(Integer idx) {
		Article article = new Article();
		return article;
	};
	
	/**
	 * 게시판 글쓰기
	 * @param title
	 * @param userNm
	 * @param content
	 * @return int
	 */
	public int createArticle(String articlePw, String title, String userNm, String content) {
		return 0;
	};
	
	/**
	 * 게시글 수정
	 * @param userNm
	 * @param title
	 * @param content
	 * @param idx
	 * @return int
	 */
	public int modifyArticle(String userNm, String articlePw, String title, String content, Integer idx) {
		return 0;
	};
	
	/**
	 * 게시글 삭제(deleted:1로 update)
	 * @param idx
	 * @return int
	 */
	public int deleteArticle(Integer idx) {
		return 0;
	};
	
	/**
	 * 비밀번호 확인 (삭제시)
	 * @param articlePw
	 * @param idx
	 * @return int
	 */
	public String checkPassword(Integer idx) {
		return "";
	};
}
