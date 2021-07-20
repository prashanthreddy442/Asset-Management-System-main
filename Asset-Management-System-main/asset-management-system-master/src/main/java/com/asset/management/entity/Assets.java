package com.asset.management.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="assets")
public class Assets implements Serializable {
	
	@Id
	@GenericGenerator(name = "asset_auto", strategy = "increment")
	@GeneratedValue(generator ="asset_auto")
    @Column(name="asset_id")
	private long assetid;
	
	@Column(name="asset_name")
	private String assetname;
	
	@Column(name="category")
	private String category;
	
	@Column(name="status")
	private String status;
	
	public Assets() {
		super();
		
	}
	public Assets(String assetname, String category, String status) {
		super();
		this.assetname = assetname;
		this.category = category;
		this.status = status;
	}


	@OneToOne(mappedBy="assets", cascade=CascadeType.ALL)
	private Allocation allocation;

	public long getAssetid() {
		return assetid;
	}

	public String getAssetname() {
		return assetname;
	}

	public String getCategory() {
		return category;
	}

	public String getStatus() {
		return status;
	}

	public void setAssetid(long assetid) {
		this.assetid = assetid;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Assets [assetid=" + assetid + ", assetname=" + assetname + ", category=" + category + ", status="
				+ status + "]";
	}
	
}
