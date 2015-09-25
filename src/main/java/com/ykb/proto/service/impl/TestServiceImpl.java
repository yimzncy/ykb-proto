package com.ykb.proto.service.impl;

import org.springframework.stereotype.Service;

import com.ykb.proto.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public void test() {
		System.out.println("test");
		
		throw new RuntimeException("ERROR PAPAPA");
	}
	
	public void ttA() {
		System.out.println("AAA");
	}
	
	public void ttB() {
		System.out.println("BBB");
	}

}
