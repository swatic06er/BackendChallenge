package com.backendChallenge.service;

import com.backendChallenge.constants.ErrorMessages;
import com.backendChallenge.dao.PowerDao;
import com.backendChallenge.entity.PowerEntity;
import com.backendChallenge.exception.NoDataException;
import java.util.List;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PowerServiceImpl implements PowerService{

	@Autowired
	private PowerDao powerDao;
	
	
	
	
	@Override
	public void saveData(PowerEntity powerentity) {
		powerDao.save(powerentity);
		
	}
	
	



	@Override
	public JSONArray getDataWithinRange(String minRange, String maxRange) throws NoDataException {
		List<PowerEntity> result=powerDao.findByRangeBetween(minRange,maxRange);
		if(result.isEmpty()) {
			throw new NoDataException(ErrorMessages.NoDataErrorMsg);
		}
		List<String> nameList = result.stream().map(PowerEntity -> PowerEntity.getName()).collect(Collectors.toList());
        List<Integer> capacityList=result.stream().map(PowerEntity -> PowerEntity.getCapacity()).collect(Collectors.toList());
        int sumList=capacityList.stream().mapToInt(i -> i).sum();
        int avg=sumList/capacityList.size();
        JSONArray jsonList = new JSONArray();
        jsonList.add(nameList);
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("TotalWattCapacity", sumList);
        jsonobj.put("AverageWattCapacity", avg);
        jsonList.add(jsonobj);
        
        return jsonList;
		
	}

}
