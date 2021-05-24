package com.telusko.web;

import org.springframework.stereotype.Component;

@Component
public class AddService {
	
	public int addMe(int i,int j) {
		return i+j;
	}

}
