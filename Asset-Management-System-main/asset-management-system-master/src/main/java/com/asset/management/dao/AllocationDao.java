package com.asset.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asset.management.entity.Allocation;

public interface AllocationDao extends JpaRepository<Allocation ,Long> {

	
	
}
