package com.asset.management.service;

import java.util.List;
import com.asset.management.entity.Allocation;

public interface AllocationService {
	public List<Allocation>getAllocations();
	public Allocation getAllocation(long allocationId);
	public Allocation addAllocation(Allocation allocation);
	
	


}
