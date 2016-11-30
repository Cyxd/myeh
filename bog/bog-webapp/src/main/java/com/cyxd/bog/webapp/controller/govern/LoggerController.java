package com.cyxd.bog.webapp.controller.govern;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyxd.bog.base.exception.UnknownResourceException;
import com.cyxd.bog.model.op.Logger;
import com.cyxd.bog.service.op.LoggerService;

@RequestMapping(LoggerController.REQUEST_MAPPING_TYPE)
public @RestController class LoggerController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	final static String REQUEST_MAPPING_TYPE = "/logger";
	final static String REQUEST_MAPPING_INDEXSHOW = "/op/logger-list";

	@Resource
	LoggerService loggerService;

	@RequestMapping(value = "/index/", method = RequestMethod.GET)
	public List<Logger> indexShow(@RequestParam(required = false) String usr) {
		
		logger.error("usr -->" + usr);

		// any other lookup throws an exception (not found):
		if (!StringUtils.hasText(usr)) {
			throw new UnknownResourceException("Unable to find user with username '" + usr + "'");
		}

		// Gson gson = new GsonBuilder().serializeNulls().create();
		return loggerService.baseList();
		// System.out.println("rst -->" + rst);
		// return rst;
		// return REQUEST_MAPPING_INDEXSHOW;
	}

}
