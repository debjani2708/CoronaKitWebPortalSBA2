package com.wellsfaro.fsd.sba2.coronakit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(CoronaKitException.class)
	public ModelAndView ErrorPage(CoronaKitException exp)
	{
		return new ModelAndView("errPage","errMsg",exp.getMessage());		
	}

}
