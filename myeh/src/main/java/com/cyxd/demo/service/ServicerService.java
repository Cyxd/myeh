package com.cyxd.demo.service;

import java.util.List;

import com.cyxd.demo.dto.Servicer;

/**
 * @ClassName: ServicerService
 * @Company: 互联在线
 * @Description: TODO
 * @author 技术部-任星东
 * @date 2016年7月28日 下午4:58:13
 *
 */
public interface ServicerService {

	Integer findCountBySelective4Behind(Servicer arg0);

	List<Servicer> findBySelective4Behind(Servicer arg0);

	int update(Servicer arg0);

	int add(Servicer arg0);

}
