package com.asset.management.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

    @Entity
	@Table(name = "asset_request")
	public class Allocation implements Serializable {
    	@Id
    	@GenericGenerator(name = "request_auto", strategy = "increment")
    	@GeneratedValue(generator ="request_auto")
    	
    	@Column(name="id")
    	private long id;
    	
    	@Column(name="request_date")
    	private Date requestdate;
    	
    	@Column(name="approve_date")
    	private Date approvedate;
    	
    	
    	@Column(name="status")
    	private String status;
    	
    	
    	@Column(name="comment")
    	private String comment;

		@OneToOne(cascade = CascadeType.ALL)
		@PrimaryKeyJoinColumn(name="id", referencedColumnName="user_id")
		private Users users_profile;

		@OneToOne(cascade = CascadeType.ALL)
		@PrimaryKeyJoinColumn(name="id", referencedColumnName="asset_id")
		private Assets assets;


		public long getId() {
			return id;
		}


		public Date getRequestdate() {
			return requestdate;
		}


		public Date getApprovedate() {
			return approvedate;
		}


		public String getStatus() {
			return status;
		}


		public String getComment() {
			return comment;
		}


		public void setId(long id) {
			this.id = id;
		}


		public void setRequestdate(Date requestdate) {
			this.requestdate = requestdate;
		}


		public void setApprovedate(Date approvedate) {
			this.approvedate = approvedate;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public void setComment(String comment) {
			this.comment = comment;
		}


		@Override
		public String toString() {
			return "Allocation [id=" + id + ", requestdate=" + requestdate + ", approvedate=" + approvedate
					+ ", status=" + status + ", comment=" + comment + "]";
		}

		public Users getUsers_profile() {
			return users_profile;
		}

		public void setUsers_profile(Users users_profile) {
			this.users_profile = users_profile;
		}

		public Assets getAssets() {
			return assets;
		}

		public void setAssets(Assets assets) {
			this.assets = assets;
		}
	}
    	