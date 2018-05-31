package com.handmakestore.service;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ErrorUtil {

    public static class HMSValidationException extends RuntimeException {

    }

    public static HMSValidationException validationException(List<ObjectError> errors) {
        return new HMSValidationException();
    }
}
