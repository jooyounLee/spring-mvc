package kr.mz.study.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Page Not Found")
public class PageNotFoundException extends Exception{

	public PageNotFoundException(int page) {
		super("PageNotFoundException with page=" + page);
	}
}
