package com.anna.component.userscreenmaster;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SCREEN_MODULE_OS")
public class ScreenModule {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MODULEUID")
	private BigDecimal moduleUid;
	
	@Column(name="MODULEID")
	private String moduleId;
	
	@Column(name="MODULENAME")
	private String moduleName;
	
	@Column(name="CREATEDBY")
	private String createdBy ;
	
	@Column(name="MODIFIEDBY")
	private String modifiedBy;
	
	@Column(name="CREATEDDATE")
	 @JsonFormat
     (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date createdDate;
	
	@Column(name="MODIFYDATE")
	 @JsonFormat
     (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date modifyDate;
	
	@Column(name="MODULESTATUS")
	private String moduleStatus;
	
	 // @JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "screenModule", cascade = CascadeType.ALL)
	private List<ScreenMaster> screenMasterList;
	
	
	
	public ScreenModule() {
	}



	public ScreenModule(BigDecimal moduleUid, String moduleId, String moduleName, String createdBy, String modifiedBy,
			Date createdDate, Date modifyDate, String moduleStatus, List<ScreenMaster> screenMasterList) {
		super();
		this.moduleUid = moduleUid;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.moduleStatus = moduleStatus;
		this.screenMasterList = screenMasterList;
	}



	public BigDecimal getModuleUid() {
		return moduleUid;
	}



	public void setModuleUid(BigDecimal moduleUid) {
		this.moduleUid = moduleUid;
	}



	public String getModuleId() {
		return moduleId;
	}



	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}



	



	public String getModuleName() {
		return moduleName;
	}



	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}



	public String getModuleStatus() {
		return moduleStatus;
	}



	public void setModuleStatus(String moduleStatus) {
		this.moduleStatus = moduleStatus;
	}



	public List<ScreenMaster> getScreenMasterList() {
		return screenMasterList;
	}



	public void setScreenMasterList(List<ScreenMaster> screenMasterList) {
		this.screenMasterList = screenMasterList;
	}









	
	
	
	
	
	


	


	
	
	

}
