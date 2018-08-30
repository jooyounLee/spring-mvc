package kr.mz.study.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Delete Failed")
public class DeleteFailedException extends Exception{

	public DeleteFailedException() {
		super("DeleteFailedException");
	}
}
