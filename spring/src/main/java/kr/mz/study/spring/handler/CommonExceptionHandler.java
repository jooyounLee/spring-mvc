package kr.mz.study.spring.handler;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView commonException(HttpServletRequest request, Exception e) {
		
		logger.info(e.toString());
		
		ModelAndView mv = new ModelAndView("/commons/common_error");
		mv.addObject("exception", e);
		mv.addObject("url", request.getRequestURL());
		
		return mv;
	}
}
