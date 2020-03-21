package com.trillion.vcemployerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2954205126168296363L;

	public RecordNotFoundException(final String message) {
        super(message);
    }

    public RecordNotFoundException(final Long id, final String lookUpItem) {
        super("Could not find " + lookUpItem + " '" + id + "'.");
    }
}
