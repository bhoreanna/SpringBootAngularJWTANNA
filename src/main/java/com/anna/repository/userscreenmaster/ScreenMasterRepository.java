package com.anna.repository.userscreenmaster;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.userscreenmaster.ScreenMaster;
import com.anna.component.userscreenmaster.ScreenModule;

@Repository
public interface ScreenMasterRepository extends CrudRepository<ScreenMaster , BigDecimal>{
	// Find By  BigDecimal moduleUid
	 public 	List<ScreenMaster> findByScreenModule(ScreenModule screenModule );

}
