package com.backendChallenge.service;

import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;

import com.backendChallenge.entity.PowerEntity;

public interface PowerService {

	public void saveData(PowerEntity powerentity) ;
	
	
	public JSONArray getDataWithinRange(String minRange,String maxRange);
		
	
}
