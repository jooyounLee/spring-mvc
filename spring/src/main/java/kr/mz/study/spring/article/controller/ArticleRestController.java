package kr.mz.study.spring.article.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.article.service.ArticleService;
import kr.mz.study.spring.exception.DeleteFailedException;
import kr.mz.study.spring.exception.InsertFailedException;
import kr.mz.study.spring.exception.UpdateFailedException;

@RestController
public class ArticleRestController {
	
	@Resource(name="articleService")
	private ArticleService articleService;
	
	
	/**
	 * 글 저장 (새글, 수정)
	 * @param article
	 * @return int
	 */
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public int save(@ModelAttribute Article article) {
		int result = 0;

		if(article.getIdx() != null) {
			try {
				result = articleService.update(article);
			} catch(UpdateFailedException e) {
				result = 0;
			}
		} else {
			try {
				result = articleService.save(article);
			} catch(InsertFailedException e) {
				result = 0;
			}
		}
		
		return result; 
	}

	/**
	 * delete
	 * @param article
	 * @return boolean
	 */
	@RequestMapping(value="/article/delete", method=RequestMethod.POST)
	public boolean delete( @ModelAttribute Article article) {			
		int result = 0;
		
		try {
			result = articleService.delete(article);
		} catch(DeleteFailedException e) {
			result = 0;
		}

		return (result < 1) ? false : true;
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
