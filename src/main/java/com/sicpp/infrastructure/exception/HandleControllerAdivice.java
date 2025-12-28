package com.sicpp.infrastructure.exception;


import com.sicpp.core.exception.AuthenticateException;
import com.sicpp.core.exception.EmailException;
import com.sicpp.core.exception.enums.ErrorCodeEnum;
import com.sicpp.infrastructure.dto.response.BaseResponse;
import com.sicpp.infrastructure.dto.response.ErrorResponse;
import com.sicpp.infrastructure.dto.response.ValidationError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandleControllerAdivice {

    @ExceptionHandler(AuthenticateException.class)
    public ResponseEntity<BaseResponse<String>> handleAuthenticateException(AuthenticateException ex, WebRequest request){
        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );
        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<BaseResponse<String>> handleEmailException(EmailException ex, WebRequest request){
        var error = new ErrorResponse(
                ex.getMessage(),
                ex.getCode(),
                null
        );
        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).build(), HttpStatus.BAD_REQUEST);
    }
}
