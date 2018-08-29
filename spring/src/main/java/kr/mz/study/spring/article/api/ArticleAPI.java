package kr.mz.study.spring.article.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.article.service.ArticleService;

@RestController
public class ArticleAPI {
	
	@Resource(name="articleService")
	private ArticleService articleService;
	
	/**
	 * 글작성 insert
	 * @param Article
	 * @return Article
	 */
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public int insert(@RequestBody Article article) {
		
		return articleService.insertArticle(article);
	}
	
	/**
	 * 글수정 update
	 * @param article
	 * @return int
	 */
	@RequestMapping(value="/article", method=RequestMethod.PUT)
	public int update(@RequestBody Article article) {
		
		boolean updateResult = articleService.updateArticle(article);
		
		return (updateResult) ? 1 : 0;
	}
	
	/**
	 * 글삭제 delete
	 * @param article
	 * @return boolean
	 */
	@RequestMapping(value="/article", method=RequestMethod.DELETE)
	public boolean delete(@RequestBody Article article) {
		
		boolean deleteResult = articleService.deleteArticle(article);
		return deleteResult;
	}

	/**
	 * 비밀번호 확인하기
	 * @param article
	 * @return boolean
	 */
	@RequestMapping(value="/password", method=RequestMethod.GET)
	public boolean selectPassword(Article article) {

		boolean checkPassResult = articleService.selectPassword(article);
		return checkPassResult;
	}

}
