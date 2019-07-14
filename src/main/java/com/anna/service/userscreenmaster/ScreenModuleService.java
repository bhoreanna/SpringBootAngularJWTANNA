package com.anna.service.userscreenmaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.userscreenmaster.ScreenModuleServiceInterface;
import com.anna.component.userscreenmaster.ScreenMaster;
import com.anna.component.userscreenmaster.ScreenModule;
import com.anna.repository.userscreenmaster.ScreenModuleRepository;

@Service
public class ScreenModuleService implements ScreenModuleServiceInterface{
	
	@Autowired
	ScreenModuleRepository repository;
	
	public ScreenModuleService() {
	}

	@Override
	public List<ScreenModule> getScreenModuleList() {
		return (List<ScreenModule>)repository.findAll() ;	}

	@Override
	public ScreenModule saveScreenModule(ScreenModule screenModule) {
		repository.save(screenModule);
		return screenModule;
	}

	@Override
	public Optional<ScreenModule> searchScreenModule(BigDecimal moduleUid) {
		return repository.findById(moduleUid);
	}

	@Override
	public int deleteScreenModule(BigDecimal moduleUid) {
		 repository.deleteById(moduleUid);
		 return 1;
	}

	@Override
	public ScreenModule updateScreenModule(ScreenModule screenModule) {
		repository.save(screenModule);
		return screenModule;
	}

}
