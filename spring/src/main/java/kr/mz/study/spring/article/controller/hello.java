package kr.mz.study.spring.article.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.mz.study.spring.article.dao.TestDAO;

@Controller
public class hello {
	
	@Autowired private SqlSession sqlSession;
	
	@RequestMapping("/hello")
	public String helolo() {
		return "hello";
	}
	
	@RequestMapping(value = "/test")
	public String select(){
		TestDAO dao = sqlSession.getMapper(TestDAO.class);
		String aa = dao.testlist();
		System.err.println("222>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : " + aa);
		return "hello";
	}

}
