package com.main.product_app.advice;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.main.product_app.exception.CategoryAlreadyExistsException;
import com.main.product_app.exception.CategoryNotFoundException;

@RestControllerAdvice
public class GlobalExceptionAdvice  {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody  public HashMap<String,String> categegoryNotFound(MethodArgumentNotValidException exception)
  {

    HashMap<String,String> map = new HashMap<>();
    exception.getBindingResult().getFieldErrors().forEach(
        (a)-> map.put(a.getField(),a.getDefaultMessage())
    );

    return map;
  }

  @ExceptionHandler(CategoryAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody  public HashMap<String,String> categegoryNotFound(CategoryAlreadyExistsException exception)
  {

    HashMap<String,String> map = new HashMap<>();
    map.put("errormessage", exception.getMessage());

    return map;
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody  public HashMap<String,String> categegoryNotFound(CategoryNotFoundException exception)
  {

      HashMap<String,String> map = new HashMap<>();
      map.put("errormessage", exception.getMessage());

      return map;
  }
}
