package com.classmanagement.ExceptionHandler;

import com.classmanagement.ClassManagementApplication;
import com.classmanagement.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    static Logger logger = LoggerFactory.getLogger(ClassManagementApplication.class);
    @ExceptionHandler(Exception.class)
    protected Result handleException(Exception e){
        logger.error(e.toString());
        return Result.fail(e.toString());
    }
}
