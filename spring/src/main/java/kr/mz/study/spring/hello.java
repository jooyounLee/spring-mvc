package kr.mz.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hello {
	
	@RequestMapping("/hello")
	public String helolo() {
		return "hello";
	}

}
