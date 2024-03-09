package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class MainController {

    @GetMapping("/sum/{op1}/{op2}")
    public Long sum(@PathVariable Long op1, @PathVariable Long op2) {
        return op1 + op2;
    }

    @GetMapping("/subtract/{op1}/{op2}")
    public Long subtract(@PathVariable Long op1, @PathVariable Long op2) {
        return op1 - op2;
    }

    @GetMapping("/div/{op1}/{op2}")
    public double div(@PathVariable Long op1, @PathVariable Long op2) throws ArithmeticException {
        if (op2 == 0) {
            throw new ArithmeticException("second operation couldn't be zero");
        }
        return (double) op1 / (double) op2;
    }

    @GetMapping("/mult/{op1}/{op2}")
    public Long mult(@PathVariable Long op1, @PathVariable Long op2) {
        return op1 * op2;
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleArithmeticException(ArithmeticException e) {
        return e.getMessage();
    }

}
