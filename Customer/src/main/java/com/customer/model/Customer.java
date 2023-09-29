package com.customer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer cutomerId;
	private String customerName;
	private long customerPhoneNo;
	private long currentPlanId;
	private String currentPlanName;
	private List<Long> selectedAddOnIds;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer cutomerId, String customerName, long customerPhoneNo, long currentPlanId,
			String currentPlanName, List<Long> selectedAddOnIds) {
		super();
		this.cutomerId = cutomerId;
		this.customerName = customerName;
		this.customerPhoneNo = customerPhoneNo;
		this.currentPlanId = currentPlanId;
		this.currentPlanName = currentPlanName;
		this.selectedAddOnIds = selectedAddOnIds;
	}
	public Integer getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(Integer cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public long getCurrentPlanId() {
		return currentPlanId;
	}
	public void setCurrentPlanId(long currentPlanId) {
		this.currentPlanId = currentPlanId;
	}
	public String getCurrentPlanName() {
		return currentPlanName;
	}
	public void setCurrentPlanName(String currentPlanName) {
		this.currentPlanName = currentPlanName;
	}
	public List<Long> getSelectedAddOnIds() {
		return selectedAddOnIds;
	}
	public void setSelectedAddOnIds(List<Long> selectedAddOnIds) {
		this.selectedAddOnIds = selectedAddOnIds;
	}
	
	@Override
	public String toString() {
		return "Customer [cutomerId=" + cutomerId + ", customerName=" + customerName + ", customerPhoneNo="
				+ customerPhoneNo + ", currentPlanId=" + currentPlanId + ", currentPlanName=" + currentPlanName
				+ ", selectedAddOnIds=" + selectedAddOnIds + "]";
	}
	
}
