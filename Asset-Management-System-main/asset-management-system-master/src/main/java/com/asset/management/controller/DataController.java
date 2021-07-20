package com.asset.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.asset.management.entity.Data;
import com.asset.management.service.DataService;

    @RestController
	public class DataController {
		
		@Autowired
		private DataService dataService;
		
		@GetMapping("/datas")
	    public List<Data> getDatas()
	    {
			return this.dataService.getDatas();
	    	
	    }
		
		@GetMapping("/datas/{dataId}")
		public Data getData(@PathVariable String dataId)
		{
			return this.dataService.getData(Long.parseLong(dataId));
		}
		@PostMapping("/datas")
		public Data addData(@RequestBody Data data)
		{
			return this.dataService.addData(data);
		}
}
