package com.asset.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asset.management.entity.Data;

public interface DataDao extends JpaRepository<Data,Long>{ 

}
