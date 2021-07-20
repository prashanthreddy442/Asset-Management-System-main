package com.asset.management.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asset.management.dao.AllocationDao;
import com.asset.management.entity.Allocation;

@Service
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AllocationServiceImpl implements AllocationService {
@Autowired
	private AllocationDao allocationDao;
	public AllocationServiceImpl() {
		
	}

	@Override
	public List<Allocation> getAllocations() {
		
		return allocationDao.findAll();
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Allocation getAllocation(long allocationId) {
		
		return allocationDao.getOne(allocationId);
	}

	@Override
	public Allocation addAllocation(Allocation allocation) {
		allocationDao.save(allocation);
		return allocation;
	}

}
