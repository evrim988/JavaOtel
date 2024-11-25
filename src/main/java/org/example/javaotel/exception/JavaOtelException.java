package org.example.javaotel.exception;

import lombok.Getter;

@Getter
public class JavaOtelException extends RuntimeException{
    private ErrorType errorType;
    public JavaOtelException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
