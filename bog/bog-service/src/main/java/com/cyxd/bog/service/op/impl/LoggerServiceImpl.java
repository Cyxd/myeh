package com.cyxd.bog.service.op.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyxd.bog.dao.op.LoggerMapper;
import com.cyxd.bog.model.op.Logger;
import com.cyxd.bog.service.op.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService{
    
    @Resource LoggerMapper loggerDao;

    @Override
    public List<Logger> baseList() {
	return loggerDao.baseList();
    }

}
