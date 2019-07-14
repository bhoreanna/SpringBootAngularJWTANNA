package com.anna.boinerface.userscreenmaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.anna.component.userscreenmaster.ScreenModule;


public interface ScreenModuleServiceInterface {

	public List<ScreenModule> getScreenModuleList();
	public ScreenModule saveScreenModule(ScreenModule screenModule);
	public Optional<ScreenModule> searchScreenModule(BigDecimal moduleUid);
	public int deleteScreenModule(BigDecimal moduleUid);
	public ScreenModule updateScreenModule(ScreenModule screenModule);

}
