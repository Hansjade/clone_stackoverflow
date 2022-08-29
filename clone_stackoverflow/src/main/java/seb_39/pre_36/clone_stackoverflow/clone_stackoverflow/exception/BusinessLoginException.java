package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.exception;

import lombok.Getter;

public class BusinessLoginException extends RuntimeException {

    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLoginException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
