package com.anna.service.userscreenmaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.boinerface.userscreenmaster.ScreenMasterServiceInterface;
import com.anna.component.userscreenmaster.ScreenMaster;
import com.anna.component.userscreenmaster.ScreenModule;
import com.anna.repository.userscreenmaster.ScreenMasterRepository;

@Service
public class ScreenMasterService implements ScreenMasterServiceInterface {

	@Autowired
	ScreenMasterRepository repository;
	public ScreenMasterService() {
	}

	@Override
	public List<ScreenMaster> getScreenMasterList() {
		return (List<ScreenMaster>)repository.findAll() ;	}

	@Override
	public ScreenMaster saveScreenMaster(ScreenMaster screenMaster) {
		repository.save(screenMaster);
		return screenMaster;
	}

	@Override
	public Optional<ScreenMaster> searchScreenMaster(BigDecimal screenMasterUid) {
		return repository.findById(screenMasterUid);
	}

	@Override
	public int deleteScreenMaster(BigDecimal screenMasterUid) {
		 repository.deleteById(screenMasterUid);
		 return 1;
	}

	@Override
	public ScreenMaster updateScreenMaster(ScreenMaster screenMaster) {
		repository.save(screenMaster);
		return screenMaster;
	}

	@Override
	public List<ScreenMaster> getScreenMasterListByModuleUid(ScreenModule screenModule) {
		// TODO Auto-generated method stub
		return repository.findByScreenModule(screenModule);
	}


}
