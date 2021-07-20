package com.asset.management.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.entity.Allocation;
import com.asset.management.service.AllocationService;



@RestController
public class AllocationController {
	
	@Autowired
	private AllocationService allocationService;
	
	@GetMapping("/allocations")
    public List<Allocation> getAllocations()
    {
		return this.allocationService.getAllocations();
    	
    }
	
	@GetMapping("/allocations/{allocationId}")
	public Allocation getAllocation(@PathVariable String allocationId)
	{
		return this.allocationService.getAllocation(Long.parseLong(allocationId));
	}
	@PostMapping("/allocations")
	public Allocation addAllocation(@RequestBody Allocation allocation)
	{
		return this.allocationService.addAllocation(allocation);
	}
	
	
	
}
