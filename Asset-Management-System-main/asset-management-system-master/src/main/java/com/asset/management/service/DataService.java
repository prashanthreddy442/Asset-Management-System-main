package com.asset.management.service;

import java.util.List;
import com.asset.management.entity.Data;

public interface DataService {
   public List<Data>getDatas();
	public Data getData(long dataId);
	public Data addData(Data data);

	
}
