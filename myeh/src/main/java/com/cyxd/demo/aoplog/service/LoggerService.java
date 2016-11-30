package com.cyxd.demo.aoplog.service;

import java.util.List;

import com.cyxd.demo.aoplog.po.Logger;

public interface LoggerService {

	int addLogging(Logger arg0);

	Integer findCountBySelective4Behind(Logger arg0);

	List<Logger> findBySelective4Behind(Logger arg0);

	int update(Logger arg0);

	int add(Logger arg0);

}
