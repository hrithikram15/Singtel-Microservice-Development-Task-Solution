package com.addOn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addOn.model.AddOn;

@Repository
public interface AddOnRepo extends JpaRepository<AddOn, Integer>{
	
	public List<AddOn> findByCategory(String category);
	public List<AddOn> findByFeatureNameContainingIgnoreCase(String name);
	public List<AddOn> findByCostContainingIgnoreCase(String cost);

}
