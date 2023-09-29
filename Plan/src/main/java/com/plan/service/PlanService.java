package com.plan.service;

import java.util.List;

import com.plan.exception.PlanAlreadyExistsException;
import com.plan.exception.PlanNotFoundException;
import com.plan.model.Plan;

public interface PlanService {
	public Plan addNewPlan(Plan plan) throws PlanAlreadyExistsException;
	public boolean deletePlan(Integer pId) throws PlanNotFoundException;
	public Plan updatePlan(Plan plan, Integer pId) throws PlanNotFoundException;
	public Plan getPlanById(Integer pId) throws PlanNotFoundException;
//	public Plan getPlanByName(String planName);
	
	public List<Plan> getAllPlans();
	public List<Plan> getPlansByName(String name);
	public List<Plan> getPlansByCost(String cost);
	public List<Plan> getPlansByDetails(String details);

}
