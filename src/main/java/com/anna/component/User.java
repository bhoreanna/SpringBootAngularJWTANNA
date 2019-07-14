package com.anna.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name=" MASTER_USER") 
@ApiModel(description="ABOUT USER API DETIALS ")
public class User {
	@Id
	@Column(name="USERNAME")

	
	@ApiModelProperty(notes="User Name should have minimum 4 charactar")
	@Size(min=4, message="User Name should have 4 charactar")
	private String userName;
	
	@ApiModelProperty(notes="Password should have minimum 4 charactar")
	@Size(min=4, message="Password should have 4 charactar")
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="USERROLE")
	private String userRole;
	
	public User()
	{
		
	}

	public User(String userName, String password, String email, String firstName, String lastName, String userRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userRole=" + userRole + "]";
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	

}
