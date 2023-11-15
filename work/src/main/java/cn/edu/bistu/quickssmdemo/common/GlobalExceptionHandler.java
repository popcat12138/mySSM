package cn.edu.bistu.quickssmdemo.common;

import cn.edu.bistu.quickssmdemo.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResultException.class)
    @ResponseBody
    public Result handle(ResultException se){
        return Result.error(se.getCode(), se.getMessage());
    }

}
