package com.backendChallenge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import com.backendChallenge.entity.PowerEntity;

@Repository
public interface PowerDao  extends JpaRepository<PowerEntity,String>{

	@Query(value="SELECT * FROM PowerData p where p.postcode>=?1 and p.postcode<=?2 order by p.name",nativeQuery=true)
     public List<PowerEntity> findByRangeBetween(String minRange,String maxRange);

    
}
