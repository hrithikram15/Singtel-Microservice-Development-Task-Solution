package com.addOn.service;

import java.util.List;

import com.addOn.model.AddOn;

public interface AddOnService {

	public AddOn addNewAddOn(AddOn aObj);
	public boolean deleteAddOn(Integer addOnId);
	public AddOn updateAddOn(AddOn aObj, Integer addOnId);
	public AddOn getPlanById(Integer addOnId);
	
	public List<AddOn> getAllAddOns();
	public List<AddOn> getAddOnsByCategory(String category);

	public List<AddOn> getAddOnsByFeatureName(String featureName);
	public List<AddOn> getAddOnsByCost(String cost);
}
