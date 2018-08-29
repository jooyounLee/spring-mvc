package kr.mz.study.spring.article.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	 * @return ModelAndView
	 * @throws PageNotFoundException 
	 */
	@RequestMapping(value="/articles")
	public ModelAndView selectArticles(@RequestParam(value="page", required=false) Integer pageParam) throws PageNotFoundException{
		
		ModelAndView mv = new ModelAndView("index");
		
		Map<String, Object> articles = articleService.selectArticles(pageParam);
		mv.addObject("articles", articles.get("articles"));
		mv.addObject("totalPostCount", articles.get("totalPostCount"));
		mv.addObject("countPostPerPage", articles.get("countPostPerPage"));
		mv.addObject("selectPageNum", articles.get("selectPageNum"));
		
		return mv;
	}
	
	/**
	 * 게시글 상세 select
	 * @param idx
	 * @return ModelAndView
	 * @throws ArticleNotFoundException 
	 */
	@RequestMapping(value="/article", method=RequestMethod.GET) 
	public ModelAndView select(Integer idx) throws ArticleNotFoundException {
		
		ModelAndView mv = new ModelAndView("readForm");
		
		Article article = articleService.selectArticle(idx);
		mv.addObject("articleRead", article);
		
		return mv;
	}
	
	/**
	 * 글쓰기 폼 이동
	 * @return /form.jsp
	 */
	@RequestMapping(value="/form") 
	public String writeForm() {
		return "form";
	}
	
	/**
	 * 글수정 폼 이동
	 * @param idx
	 * @return ModelAndView
	 * @throws ArticleNotFoundException 
	 */
	@RequestMapping(value="/form/update")
	public ModelAndView updateForm(Integer idx) throws ArticleNotFoundException {
		
		ModelAndView mv = new ModelAndView("form");
		
		Article article = articleService.selectArticle(idx);
		mv.addObject("articleUpdate", article);
		
		return mv;
	}
}
