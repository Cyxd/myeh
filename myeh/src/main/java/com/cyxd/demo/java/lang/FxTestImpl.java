package com.cyxd.demo.java.lang;

import com.cyxd.demo.demo2.JSONDto;
import com.cyxd.demo.dto.Servicer;

public class FxTestImpl implements FxTest<Servicer, Servicer, JSONDto>{

	@Override
	public Servicer getK() {
		// TODO Auto-generated method stub
		return new Servicer();
	}

	@Override
	public Servicer getV() {
		// TODO Auto-generated method stub
		return new Servicer();
	}

	@Override
	public JSONDto getS() {
		// TODO Auto-generated method stub
		return new JSONDto();
	}

}
