package com.sf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/1/15.
 */
@Controller
public class HelloAction {
    @RequestMapping(value = "hello")
    public ModelAndView hello() {
        return new ModelAndView("index");
    }
}
