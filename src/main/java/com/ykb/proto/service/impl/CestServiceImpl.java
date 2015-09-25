package com.ykb.proto.service.impl;

import com.ykb.proto.service.CestService;

public class CestServiceImpl implements CestService {

	@Override
	public void cest() {
		System.out.println("cest");
	}
	
	@Override
	public void cc(String a, String b) {
		System.out.println(a + b);;
	}

}
