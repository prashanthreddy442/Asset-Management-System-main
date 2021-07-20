package com.asset.management.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userdata")
    public class Data {
	@Id
	@GenericGenerator(name = "Data_auto", strategy = "increment")
	@GeneratedValue(generator ="data_auto")
	
	@Column(name = "id")
    private  long id;
	
	@Column(name = "email")
    private  String email;
	
	@Column(name = "password")
    private  String password;
	
    public Data() {
    }
    public Data( String email, 
                 String password) {
        this.email = email;
        this.password = password;
        
    }
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
   
}
