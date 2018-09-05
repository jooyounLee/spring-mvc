package kr.mz.study.spring.article.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.mz.study.spring.article.groups.ArticleGroups;
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
	 * @throws UpdateFailedException 
	 * @throws InsertFailedException 
	 */
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public int insert(@ModelAttribute @Valid Article article, BindingResult bindingResult) throws InsertFailedException {
		int result = 0;

		if(articleService.save(article) > 0) {
			result = articleService.save(article);
		} else {
			throw new InsertFailedException();
		}
		
		return result; 
	}
	
	@RequestMapping(value="/article/update", method=RequestMethod.POST)
	public int update(@ModelAttribute @Valid Article article) throws UpdateFailedException {
		int result = 0;
		
		if(articleService.update(article) > 0) {
			result = articleService.update(article);
		} else {
			throw new UpdateFailedException();
		}
		
		return result;
	}

	/**
	 * delete
	 * @param article
	 * @return boolean
	 * @throws DeleteFailedException 
	 */
	@RequestMapping(value="/article/delete", method=RequestMethod.POST)
	public boolean delete(@ModelAttribute Article article) throws DeleteFailedException {			
		int result = 0;
		
		if(articleService.delete(article) > 0) {
			result = articleService.delete(article);
		} else {
			throw new DeleteFailedException();
		}
		
		return (result < 1) ? false : true;
	}

	/**
	 * 비밀번호 확인하기
	 * @param article
	 * @return boolean
	 */
	@RequestMapping(value="/password", method=RequestMethod.GET)
	public boolean selectPassword(@Validated(ArticleGroups.Password.class) Article article) {
		boolean checkPassResult = articleService.selectPassword(article);
		return checkPassResult;
	}
}
