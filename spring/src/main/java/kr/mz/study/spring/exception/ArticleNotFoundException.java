package kr.mz.study.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Article Not Found")
public class ArticleNotFoundException extends Exception{

	public ArticleNotFoundException(int idx) {
		super("ArticleNotFoundException with idx=" + idx);
	}
}
