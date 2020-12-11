package org.academiadecodigo.hackaton.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RainhaException extends RuntimeException {

    public RainhaException(String e){
        super(e);
    }


}
