package kr.mz.study.spring.article.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.mz.study.spring.article.dao.ArticleDAO;
import kr.mz.study.spring.article.model.Article;
import kr.mz.study.spring.article.service.ArticleService;

@Controller
public class ArticleController {
	
	private Logger logger=LoggerFactory.getLogger(ArticleController.class);
	
	@Resource(name="articleService")
	private ArticleService articleService;

	
	@RequestMapping("/get_articles")
	public ModelAndView getArticles(@RequestParam(value="page", required=false) Integer pageParam) {
		
		ModelAndView mv = new ModelAndView("index");
		
		Map<String, Object> articles = articleService.getArticles(pageParam);
		mv.addObject("articles", articles.get("articles"));
		mv.addObject("totalPostCount", articles.get("totalPostCount"));
		mv.addObject("countPostPerPage", articles.get("countPostPerPage"));
		mv.addObject("selectPageNum", articles.get("selectPageNum"));
		
		logger.info("result :{}", articles.toString());
		
		return mv;
	}
	
	@RequestMapping("/get_article_detail") 
	public ModelAndView getArticleDetail(Integer idx) {
		
		ModelAndView mv = new ModelAndView("readForm");
		
		Article article = articleService.getArticleDetail(idx);
		mv.addObject("articleRead", article);
		
		return mv;
	}
	
	@RequestMapping("/form") 
	public String writeForm() {
		return "form";
	}
	
	@RequestMapping("/update_form")
	public ModelAndView updateForm(Integer idx) {
		
		ModelAndView mv = new ModelAndView("form");
		
		Article article = articleService.getArticleDetail(idx);
		mv.addObject("articleUpdate", article);
		
		return mv;
	}
	
	@RequestMapping("/article_write")
	public @ResponseBody int writeArticle(String articlePw, String title, String userNm, String content) {
		
		int createResult = articleService.createArticle(articlePw, title, userNm, content);
		
		return createResult;
	}
	
	@RequestMapping("/article_update")
	public @ResponseBody int updateArticle(String articlePw, String title, String userNm, String content, Integer idx) {
		
		boolean updateResult = articleService.updateArticle(articlePw, title, userNm, content, idx);
		
		return (updateResult) ? 1 : 0;
	}
	
	@RequestMapping("/article_delete")
	public @ResponseBody boolean deleteArticle(Integer idx, @RequestParam("re-password") String articlePw) {
		
		boolean deleteResult = articleService.deleteArticle(idx, articlePw);
		
		return deleteResult;
	}
	
	@RequestMapping("/check_pass")
	public @ResponseBody boolean checkPass(Integer idx, @RequestParam("re-password") String articlePw) {
		
		boolean checkPassResult = articleService.isCorrectPassword(idx, articlePw);
		
		return checkPassResult;
	}
	
}
