package kr.mz.study.spring.article.controller;

import java.util.Map;

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
	public String selectArticles(@RequestParam(value="page", required=false, defaultValue="1") Integer pageParam, Model model) throws PageNotFoundException{
		
		Map<String, Object> articles = articleService.findArticles(pageParam);
		
		model.addAttribute("articles", articles.get("articles"));
		model.addAttribute("totalPostCount", articles.get("totalPostCount"));
		model.addAttribute("countPostPerPage", articles.get("countPostPerPage"));
		model.addAttribute("selectPageNum", articles.get("selectPageNum"));
		
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
		
		Article article = articleService.findArticle(idx);
		article.setIdx(idx);
		model.addAttribute("article", article);
		
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

		Article article = articleService.findArticle(idx);
		article.setIdx(idx);
		model.addAttribute("article", article);
		
		return "form";
	}
	

}
