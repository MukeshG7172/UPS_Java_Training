package com.example.demo.exception;

import com.example.demo.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidations(MethodArgumentNotValidException e) {
        Map<String,String> map=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(maps->map.put(maps.getField(),maps.getDefaultMessage()));
        for (String key: map.keySet()){
            System.out.println(key+" "+map.getOrDefault(key,null));
        }
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Validation failed",map);

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}