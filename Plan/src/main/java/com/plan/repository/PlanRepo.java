package com.plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plan.model.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer> {
	
	
	public List<Plan> findByPlanNameContainingIgnoreCase(String planName);
	public List<Plan> findByCostContainingIgnoreCase(String cost);
	public List<Plan> findByDetailsContainingIgnoreCase(String details);

}
