package com.addOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addOn.model.AddOn;
import com.addOn.repository.AddOnRepo;

@Service
public class AddOnServiceImpl implements AddOnService{
	
	@Autowired
	private AddOnRepo addOnRepo;

	@Override
	public AddOn addNewAddOn(AddOn aObj) {
		Optional<AddOn> optional = this.addOnRepo.findById(aObj.getAddOnId());
		if(optional.isPresent()) {
			System.out.println("AddOn already exists");
		}
		AddOn addAddOn = this.addOnRepo.save(aObj);
		return addAddOn;
	}

	@Override
	public boolean deleteAddOn(Integer addOnId) {
		Optional<AddOn> optional = this.addOnRepo.findById(addOnId);
		boolean status = false;
		if(optional.isPresent()) {
			this.addOnRepo.delete(optional.get());
			status = true;
		}else {
			System.out.println("AddOn doesn't exist");
		}
		return status;
	}

	@Override
	public AddOn updateAddOn(AddOn aObj, Integer addOnId) {
		Optional<AddOn> optional = this.addOnRepo.findById(addOnId);
		AddOn AObj = null;
		AddOn updatedData = null;
		
		if(optional.isPresent()) {
			AObj = optional.get();
			AObj.setCost(aObj.getCost());
			AObj.setFeatureName(aObj.getFeatureName());
			updatedData = this.addOnRepo.save(AObj);
		}
		return updatedData;
	}

	@Override
	public AddOn getPlanById(Integer addOnId) {
Optional<AddOn> optional = this.addOnRepo.findById(addOnId);
		
		AddOn aObj = null;
		if(optional.isPresent()) {
			System.out.println("AddOn Found");
			aObj = optional.get();
		}else {
			System.out.println("AddOn doesn't exists");
		}
		return aObj;
	}

	@Override
	public List<AddOn> getAllAddOns() {
		return this.addOnRepo.findAll();

	}

	@Override
	public List<AddOn> getAddOnsByCategory(String category) {
		List<AddOn> addOns = this.addOnRepo.findByCategory(category);
		return addOns;
	}

	@Override
	public List<AddOn> getAddOnsByFeatureName(String featureName) {
		List<AddOn> addOns = this.addOnRepo.findByFeatureNameContainingIgnoreCase(featureName);
		return addOns;
	}

	@Override
	public List<AddOn> getAddOnsByCost(String cost) {
		List<AddOn> addOns = this.addOnRepo.findByCostContainingIgnoreCase(cost);
		return addOns;
	}

}
