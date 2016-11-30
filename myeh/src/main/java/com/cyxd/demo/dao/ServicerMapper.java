package com.cyxd.demo.dao;

import java.util.List;

import com.cyxd.demo.dto.Servicer;

/**
 * @author cyxd
 *
 */
public interface ServicerMapper {

	Integer findCountBySelective4Behind(Servicer arg0);

	List<Servicer> findBySelective4Behind(Servicer arg0);

	void update(Servicer arg0);

	void add(Servicer arg0);

}