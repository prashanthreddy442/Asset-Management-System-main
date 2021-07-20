package com.asset.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.dao.AssetsDao;
import com.asset.management.entity.Assets;
import com.asset.management.exceptions.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AssetsController {

	@Autowired
	private AssetsDao assetsDao;
	
	// get all assets
	@GetMapping("/asset")
	public List<Assets> getAllAsset(){
		return assetsDao.findAll();
	}		
	
	// create asset rest api
	@PostMapping("/asset")
	public Assets createEmployee(@RequestBody Assets assets) {
		return assetsDao.save(assets);
	}
	
	// get asset by id rest api
	@GetMapping("/asset/{id}")
	public ResponseEntity<Assets> getAssetsById(@PathVariable Long id) {
		Assets assets = assetsDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		return ResponseEntity.ok(assets);
	}
	
	// update employee rest api
	
	@PutMapping("/asset/{id}")
	public ResponseEntity<Assets> updateAssets(@PathVariable Long id, @RequestBody Assets assetsDetails){
		Assets assets = assetsDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		
		assets.setAssetname(assetsDetails.getAssetname());
		assets.setCategory(assetsDetails.getCategory());
		assets.setStatus(assetsDetails.getStatus());
		
		Assets updatedAssets = assetsDao.save(assets);
		return ResponseEntity.ok(updatedAssets);
	}
	
	// delete employee rest api
	@DeleteMapping("/asset/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAssets(@PathVariable Long id){
		Assets assets = assetsDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		
		assetsDao.delete(assets);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}