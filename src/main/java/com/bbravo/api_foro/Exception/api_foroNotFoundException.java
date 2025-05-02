package com.bbravo.api_foro.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class api_foroNotFoundException extends RuntimeException {
    
    public api_foroNotFoundException(String msg)
    {
        super(msg);
    }
}