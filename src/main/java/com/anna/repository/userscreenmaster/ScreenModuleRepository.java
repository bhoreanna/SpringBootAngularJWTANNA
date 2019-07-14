package com.anna.repository.userscreenmaster;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anna.component.userscreenmaster.ScreenModule;

@Repository

public interface ScreenModuleRepository extends CrudRepository<ScreenModule , BigDecimal> {

}
