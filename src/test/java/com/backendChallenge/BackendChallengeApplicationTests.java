package com.backendChallenge;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.backendChallenge.controller.PowerController;
import com.backendChallenge.dao.PowerDao;
import com.backendChallenge.entity.PowerEntity;
import com.backendChallenge.service.PowerServiceImpl;

@SpringBootTest
class BackendChallengeApplicationTests {
	
	@Resource
	private PowerDao powerDao;
	
	
	
	@Resource	
	private PowerServiceImpl powerImpl;
	
	
	@Resource
	private PowerController powerController;
	
	
	
	@BeforeEach
	void setup()  {
		
		PowerEntity pow=new PowerEntity();		
		pow.setName("Akunda Bay");
		pow.setCapacity(13500);
		pow.setPostcode("2084");
		
	}

	@Test
	public void givenEntityWhenSavedThenReturnTrue() {
		PowerEntity pow=new PowerEntity("AkundaBay","2084",13500);
		powerDao.save(pow);
	   Assertions.assertThat(!powerDao.findAll().isEmpty());	
		
	}
	

	@Test
	public void findDataWithinRange() {
		List<PowerEntity> list=powerDao.findByRangeBetween("3010","2000");
		Assertions.assertThat(list).isNotNull();
	}

	
	@Test
	public void finDataWithingRange_returns_BadRequest() {
		var response=powerController.getDataWithinRange("0", " ");
		Assertions.assertThat (response.getBody().equals("Range cannot be zero or Blank!"));


	}
	
	

}
