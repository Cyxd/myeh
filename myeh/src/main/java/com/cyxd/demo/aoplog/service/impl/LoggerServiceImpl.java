package com.cyxd.demo.aoplog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyxd.demo.aoplog.dao.LoggerMapper;
import com.cyxd.demo.aoplog.po.Logger;
import com.cyxd.demo.aoplog.service.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService {

	@Resource
	LoggerMapper loggerMapper;

	@Override
	public int addLogging(Logger arg0) {
		return loggerMapper.add(arg0);
	}

	@Override
	public Integer findCountBySelective4Behind(Logger arg0) {
		return loggerMapper.findCountBySelective4Behind(arg0);
	}

	@Override
	public List<Logger> findBySelective4Behind(Logger arg0) {
		return loggerMapper.findBySelective4Behind(arg0);
	}

	@Override
	public int update(Logger arg0) {
		return loggerMapper.update(arg0);
	}

	@Override
	public int add(Logger arg0) {
		loggerMapper.add(arg0);
		return 1;
	}

}
