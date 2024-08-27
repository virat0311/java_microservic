package com.pandey.crudOpsResFullServ.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class resourceNotFoundExcep extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public resourceNotFoundExcep(String resourceName,String fieldName,Long fieldValue ){
        super(String.format("%s not found with %s :'%s'",resourceName,fieldName,fieldValue)) ;
        this.fieldName=fieldName;
        this.resourceName=resourceName;
        this.fieldValue=fieldValue;
    }
}
