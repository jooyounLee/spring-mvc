package kr.mz.study.spring.article.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.article.service.ArticleService;
import kr.mz.study.spring.exception.ArticleNotFoundException;
import kr.mz.study.spring.exception.PageNotFoundException;

@Controller
public class ArticleController {
	
	@Resource(name="articleService")
	private ArticleService articleService;
	
	/**
	 * 게시판 리스트 select
	 * @param pageParam
	 * @return /index.jsp
	 * @throws PageNotFoundException 
	 */
	@RequestMapping(value="/articles")
	public String selectArticles(@RequestParam(value="offset", required=false, defaultValue="0") int offset
								, @RequestParam(value="limit", required=false, defaultValue="10") int limit
								, Model model) throws PageNotFoundException{
		if(articleService.findArticles(offset, limit) != null) {
			model.addAttribute("articles", articleService.findArticles(offset, limit));
			model.addAttribute("totalPostCount", articleService.findCountAll());
		} else {
			throw new PageNotFoundException(offset);
		}
		
		return "index";
	}
	
	/**
	 * 게시글 상세 select
	 * @param idx
	 * @return /readForm.jsp
	 * @throws ArticleNotFoundException 
	 */
	@RequestMapping(value="/article/{idx}", method=RequestMethod.GET) 
	public String select(@PathVariable("idx") Integer idx, Model model) throws ArticleNotFoundException {
		if(articleService.findArticle(idx) != null) {
			model.addAttribute("article", articleService.findArticle(idx));
		} else {
			throw new ArticleNotFoundException(idx);
		}
		
		return "readForm";
	}
	
	/**
	 * 글쓰기 폼 이동
	 * @return /form.jsp
	 */
	@RequestMapping(value="/article/save", method=RequestMethod.GET) 
	public String writeForm(Model model) {
		model.addAttribute("article", new Article());
		
		return "form";
	}
	
	/**
	 * 글수정 폼 이동
	 * @param idx
	 * @return /form.jsp
	 * @throws ArticleNotFoundException 
	 */
	@RequestMapping(value="/article/save/{idx}", method=RequestMethod.GET)
	public String updateForm(@PathVariable("idx") Integer idx, Model model) throws ArticleNotFoundException {
		if(articleService.findArticle(idx) != null) {
			model.addAttribute("article", articleService.findArticle(idx));
		} else {
			throw new ArticleNotFoundException(idx);
		}
		
		return "form";
	}
}
