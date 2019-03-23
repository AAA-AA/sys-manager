package com.github.sys.aop;

import com.github.sys.domain.common.ResponseDto;
import com.github.sys.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by renhongqiang on 2019-03-12 16:24
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseDto handleMethodArgumentNotValidException(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        log.error("MethodArgumentNotValidException", ex);
        responseInit(response);
        MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            return ResponseDto.error(HttpStatus.BAD_REQUEST.value(), errorList.get(0).getDefaultMessage());
        }
        return ResponseDto.error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    private void responseInit(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
    }

    /**
     * 全局serviceException异常处理
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseDto handleServiceException(HttpServletRequest request, HttpServletResponse response, ServiceException ex) {
        log.error("ServiceException",ex);
        responseInit(response);
        return ResponseDto.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 全局serviceException异常处理
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDto handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.error("Exception",ex);
        responseInit(response);
        return ResponseDto.error("server error! please contact admin");
    }
}
