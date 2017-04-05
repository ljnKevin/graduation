package com.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.entity.ActivityBean;

@WebService
public interface ActivityService {
	
	void addActivity(@WebParam(name = "activity") final ActivityBean activity);

}
