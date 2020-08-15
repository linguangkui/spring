package com.shop.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySpringMVCException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg = "出bug了，请联系管理员！";
        if (e instanceof MyException){
            msg = ((MyException) e).getMsg();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
