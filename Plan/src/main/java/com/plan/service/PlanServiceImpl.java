package com.plan.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan.exception.PlanAlreadyExistsException;
import com.plan.exception.PlanNotFoundException;
import com.plan.model.Plan;
import com.plan.repository.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepo planRepo;

	@Override
	public Plan addNewPlan(Plan plan) throws PlanAlreadyExistsException{
		Optional<Plan> optional = this.planRepo.findById(plan.getPlanId());
		if(optional.isPresent()) {
			System.out.println("Plan already exists");
			throw new PlanAlreadyExistsException();
		}else {
			Plan addPlan = this.planRepo.save(plan);
			return addPlan;
		}
		
	}

	@Override
	public boolean deletePlan(Integer pId) throws PlanNotFoundException{
		Optional<Plan> optional = this.planRepo.findById(pId);
		boolean status = false;
		if(optional.isPresent()) {
			this.planRepo.delete(optional.get());
			status = true;
		}else {
			System.out.println("Plan doesn't exist");
			throw new PlanNotFoundException();
		}
		return status;
	}

	@Override
	public Plan updatePlan(Plan plan, Integer pId) throws PlanNotFoundException{
		Optional<Plan> optional = this.planRepo.findById(pId);
		Plan PObj = null;
		Plan updatedData = null;
		
		if(optional.isPresent()) {
			PObj = optional.get();
			PObj.setCost(plan.getCost());
			PObj.setPlanName(plan.getPlanName());
			PObj.setDetails(plan.getDetails());
			updatedData = this.planRepo.save(PObj);
		}else {
			throw new PlanNotFoundException();
		}
		return updatedData;
	}

	@Override
	public Plan getPlanById(Integer pId) throws PlanNotFoundException{
Optional<Plan> optional = this.planRepo.findById(pId);
		
		Plan pObj = null;
		if(optional.isPresent()) {
			System.out.println("Plan Found");
			pObj = optional.get();
		}else {
			System.out.println("Plan doesn't exists");
			throw new PlanNotFoundException();
		}
		return pObj;
	}

	


	@Override
	public List<Plan> getAllPlans() {
		return this.planRepo.findAll();

	}

	@Override
	public List<Plan> getPlansByName(String planName) {
		List<Plan> plans = this.planRepo.findByPlanNameContainingIgnoreCase(planName);
		return plans;
	}

	@Override
	public List<Plan> getPlansByCost(String cost) {
		List<Plan> plans = this.planRepo.findByCostContainingIgnoreCase(cost);
		return plans;
	}

	@Override
	public List<Plan> getPlansByDetails(String details) {
		List<Plan> plans = this.planRepo.findByDetailsContainingIgnoreCase(details);
		return plans;
	}

	

}
