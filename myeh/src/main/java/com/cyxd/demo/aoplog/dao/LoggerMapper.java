package com.cyxd.demo.aoplog.dao;

import java.util.List;

import com.cyxd.demo.aoplog.po.Logger;

public interface LoggerMapper {

	Integer findCountBySelective4Behind(Logger arg0);

	List<Logger> findBySelective4Behind(Logger arg0);

	int update(Logger arg0);

	int add(Logger arg0);

}