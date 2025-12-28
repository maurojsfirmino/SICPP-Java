package com.sicpp.infrastructure.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.ErrorResponse;

@Data
@Builder
public class BaseResponse<T> {
    private Boolean success;
    private String message;
    private T result;
    private ErrorResponse error;
}
