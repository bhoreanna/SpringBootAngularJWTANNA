package com.anna.component;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" USERROLE") 
public class UserRole {

	@Id
	@Column(name="ROLENAME")

	private String roleName;
	@Column(name="CREATEDDATE")
	private Date createdDate;
	
	public UserRole()
	{
		System.out.println("In UserRole Constructor");
	}

	public UserRole(String roleName, Date createdDate) {
		super();
		this.roleName = roleName;
		this.createdDate = createdDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserRole [roleName=" + roleName + ", createdDate=" + createdDate + "]";
	}
	
	
	
}
