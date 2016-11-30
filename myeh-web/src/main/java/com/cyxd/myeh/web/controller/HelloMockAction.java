package com.cyxd.myeh.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableList;

public @Controller class HelloMockAction {

    private final static Logger logger = LoggerFactory.getLogger(HelloMockAction.class);

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public String loginView(@RequestParam(required = false) String code,
	    ModelMap model) throws Exception {
	if ("fail".equals(code)) {
	    model.put("error", "登陆验证失败，请录入正确的登陆信息");
	    throw new IllegalArgumentException("登陆验证失败，请录入正确的登陆信息");
	}
	// throw new AuthenticationFailureException("error -->" + error);
	return "login";
    }

    @RequestMapping(value = "/login2/", method = RequestMethod.POST)
    public void login() {
	if (logger.isInfoEnabled()) {
	    logger.info("login ----------------------------");
	}
    }

    @RequestMapping("/sayHi/")
    public @ResponseBody String say() {
	return "sayHi";
    }

    @RequestMapping("/sayHi2/")
    public @ResponseBody List<String> say(String strs) {
	return ImmutableList.of(strs);
    }

    @RequestMapping("/sayHi3/")
    public ModelAndView mavDemo() {
	ModelAndView mav = new ModelAndView("sayHi");
	return mav;
    }

}
