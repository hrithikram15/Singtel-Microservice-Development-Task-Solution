package com.customer.feignConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.model.Plan;

@FeignClient(name="plan-service", url="http://localhost:9091/singtel/plan")
public interface PlanFeignController {
	
	@GetMapping("/getPlansById/{planId}")
	public Plan getPlanById(@PathVariable Integer planId);

}
