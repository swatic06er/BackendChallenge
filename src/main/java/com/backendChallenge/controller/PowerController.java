package com.backendChallenge.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendChallenge.constants.ErrorMessages;
import com.backendChallenge.entity.PowerEntity;
import com.backendChallenge.service.PowerService;

@RestController
@RequestMapping("/Power")
public class PowerController {

	@Autowired
	private PowerService powerService;
	
	

	@PostMapping("/savedata")
	public ResponseEntity<String> saveData(@RequestBody PowerEntity[] powerentity) {
		
		for (PowerEntity power : powerentity) {
			 powerService.saveData(power);

		}
		return new ResponseEntity<String>("Data Saved Successfully!",HttpStatus.OK);
		
	}
	
	
	
	

	@GetMapping("/getdata/{minRange}/{maxRange}")
	public ResponseEntity<?> getDataWithinRange(@PathVariable(value = "minRange") String minRange,
										@PathVariable(value = "maxRange") String maxRange) {
		
		if(minRange.equals("0") || minRange.isBlank() || maxRange.equals("0") || maxRange.isBlank()) {
			return new ResponseEntity<>(ErrorMessages.invalidRange,HttpStatus.BAD_REQUEST);
			}

		List<JSONObject> list = powerService.getDataWithinRange(minRange, maxRange);
		return ResponseEntity.ok(list);
	}

	
	
	
	
}