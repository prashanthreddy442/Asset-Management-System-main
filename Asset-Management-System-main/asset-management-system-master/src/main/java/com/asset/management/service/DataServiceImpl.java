package com.asset.management.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asset.management.dao.DataDao;
import com.asset.management.entity.Data;

@Service
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class DataServiceImpl implements DataService {
@Autowired
	private DataDao dataDao;
	public DataServiceImpl() {
		
	}

	@Override
	public List<Data> getDatas() {
		
		return dataDao.findAll();
	}


	@SuppressWarnings("deprecation")
	@Override
	public Data getData(long dataId) {
		return dataDao.getOne(dataId);
	}

	@Override
	public Data addData(Data data) {
		dataDao.save(data);
		return data;
	}

}
