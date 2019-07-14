package com.anna.component.userscreenmaster;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;

@Entity
@Table(name = "SCREEN_MASTER_OS")
public class ScreenMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SCREENMASTERUID")
	private BigDecimal screenMasterUid;
	
	@Column(name="SCREENMASTERID")
	private String screenMasterId;
	
	@Column(name="SCREENNAME")
	private String screenName;
	
	@Column(name="	CREATEDBY")
	private String createdBy ;
	
	@Column(name="	MODIFIEDBY")
	private String modifiedBy;
	
	@Column(name="CREATEDDATE")
	 @JsonFormat
     (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date createdDate;
	
	@Column(name="MODIFYDATE")
	 @JsonFormat
     (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date modifyDate;
	
	@Column(name="SCREENSTATUS")
	private String screenStatus;
	
	@Transient
	private BigDecimal moduleUid ;
	
	
	@JsonBackReference
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "MODULEUID" )
	private  ScreenModule screenModule;
	
	
	
	
	public ScreenMaster() {
	}

	public ScreenMaster(BigDecimal screenMasterUid, String screenMasterId, String screenName, String createdBy,
			String modifiedBy, Date createdDate, Date modifyDate, String screenStatus, ScreenModule screenModule) {
		super();
		this.screenMasterUid = screenMasterUid;
		this.screenMasterId = screenMasterId;
		this.screenName = screenName;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.screenStatus = screenStatus;
		this.screenModule = screenModule;
	}

	public BigDecimal getScreenMasterUid() {
		return screenMasterUid;
	}

	public void setScreenMasterUid(BigDecimal screenMasterUid) {
		this.screenMasterUid = screenMasterUid;
	}

	public String getScreenMasterId() {
		return screenMasterId;
	}

	public void setScreenMasterId(String screenMasterId) {
		this.screenMasterId = screenMasterId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
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

	public String getScreenStatus() {
		return screenStatus;
	}

	public void setScreenStatus(String screenStatus) {
		this.screenStatus = screenStatus;
	}

	public BigDecimal getModuleUid() {
		return moduleUid;
	}

	public void setModuleUid(BigDecimal moduleUid) {
		this.moduleUid = moduleUid;
	}

	public ScreenModule getScreenModule() {
		return screenModule;
	}

	public void setScreenModule(ScreenModule screenModule) {
		this.screenModule = screenModule;
	}

	
	
	



	
	

	
	
	
	



	

	
	
	
}
