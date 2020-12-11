package org.academiadecodigo.hackaton.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = RainhaException.class)
    public ModelAndView handleClientErrors(HttpServletRequest req, RainhaException ex){

        ModelAndView mav = new ModelAndView();

        mav.addObject("request", req.getRequestURL());
        mav.addObject("error", ex.getMessage());
        mav.setViewName("error/error");

        return mav;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleServerErrors(HttpServletRequest req, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();


        modelAndView.addObject("requestType", req);
        modelAndView.addObject("exception", ex.getMessage());
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

}
