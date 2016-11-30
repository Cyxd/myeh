package com.cyxd.bog.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyxd.bog.base.exception.UnknownResourceException;

/**
 * Default controller that exists to return a proper REST response for unmapped
 * requests.
 */
@Controller
public class DefaultController {

    @RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request) {
	throw new UnknownResourceException("There is no resource for path ["
		+ request.getRequestURI() + "].");
    }

}
