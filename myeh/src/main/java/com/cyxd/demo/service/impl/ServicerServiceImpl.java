package com.cyxd.demo.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyxd.demo.aoplog.annotation.SysteamOperationServiceLogger;
import com.cyxd.demo.aoplog.constant.SystemOperateType;
import com.cyxd.demo.dao.ServicerMapper;
import com.cyxd.demo.dto.Servicer;
import com.cyxd.demo.exception.runtime.ServiceTxErrorRuntimeException;
import com.cyxd.demo.service.ServicerService;

@Service
public class ServicerServiceImpl implements ServicerService {

	@Resource
	ServicerMapper servicerMapper;

	@Override
	public Integer findCountBySelective4Behind(Servicer arg0) {
		return servicerMapper.findCountBySelective4Behind(arg0);
	}

	@Override
	public List<Servicer> findBySelective4Behind(Servicer arg0) {
		return servicerMapper.findBySelective4Behind(arg0);
	}

	@SysteamOperationServiceLogger(value = "更新客服人员信息", type = SystemOperateType.MODIFY)
	@Override
	public int update(Servicer arg0) {
		servicerMapper.update(arg0);
		if ("dfdf8129323d418fbed052a01daeff62".equals(arg0.getId()))
			throw new ServiceTxErrorRuntimeException("rollBack data");
		arg0.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		servicerMapper.add(arg0);
		System.out.println("");
		return 0;
	}

	@SysteamOperationServiceLogger(value = "添加客服人员信息", type = SystemOperateType.ADD)
	@Override
	public int add(Servicer arg0) {
		servicerMapper.add(arg0);
		return 1;
	}

}
