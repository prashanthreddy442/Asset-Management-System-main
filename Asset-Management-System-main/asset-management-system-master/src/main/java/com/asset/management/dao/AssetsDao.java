package com.asset.management.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asset.management.entity.Assets;

@Repository
public interface AssetsDao extends JpaRepository<Assets ,Long>{

}
