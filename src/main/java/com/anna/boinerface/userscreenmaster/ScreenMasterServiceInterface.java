package com.anna.boinerface.userscreenmaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.userscreenmaster.ScreenMaster;
import com.anna.component.userscreenmaster.ScreenModule;

public interface ScreenMasterServiceInterface {

	public List<ScreenMaster> getScreenMasterList();
	public ScreenMaster saveScreenMaster(ScreenMaster screenMaster);
	public Optional<ScreenMaster> searchScreenMaster(BigDecimal screenMasterUid);
	public int deleteScreenMaster(BigDecimal screenMasterUid);
	public ScreenMaster updateScreenMaster(ScreenMaster screenMaster);
	
	 public List<ScreenMaster> getScreenMasterListByModuleUid(ScreenModule screenModule );


}
