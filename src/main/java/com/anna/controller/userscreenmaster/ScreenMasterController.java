package com.anna.controller.userscreenmaster;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.userscreenmaster.ScreenMasterServiceInterface;
import com.anna.component.userscreenmaster.ScreenMaster;
import com.anna.component.userscreenmaster.ScreenModule;
//192.168.10.164:9991/screenmaster/screenMasterList
@RestController
@RequestMapping("/screenmaster")
//@CrossOrigin(origins = "http://192.168.10.165:4200", allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

 //@CrossOrigin(origins = "http://192.168.10.165:8082", allowedHeaders = "*")  //Tomcat
//@CrossOrigin(origins = "http://192.168.8.105:4200", allowedHeaders = "*")
public class ScreenMasterController {

	@Autowired
	ScreenMasterServiceInterface screenMasterService;
	public ScreenMasterController() {
		System.out.println(" I   In ScreenMasterController: ");
	}
	
	
	@RequestMapping(value = "/screenMasterList")
	public List<ScreenMaster> getScreenMasterList() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		System.out.println("i am in ScreenMasterList in main Controllar");
		List<ScreenMaster> screenMasterList = screenMasterService.getScreenMasterList();
		System.out.println(" screenMasterList Size in Controller: " + screenMasterList.size());
		System.out.println("*******************************************************");
		
		for (ScreenMaster screenMaster : screenMasterList) {
			
			System.out.println("screenMaster.getScreenModule().getModuleUid(): "+screenMaster.getScreenModule().getModuleUid());
			
			screenMaster.setModuleUid(	screenMaster.getScreenModule().getModuleUid());
			System.out.println(screenMaster);
		}
		System.out.println("*********************************************");

		return screenMasterList;
	}
	
	
	
	
	
	// BigDecimal moduleUid
	
	@RequestMapping(value = "/screenMasterListByModuleUid/{moduleUid}")
	public List<ScreenMaster> getScreenMasterListByModuleUid(@PathVariable(name="moduleUid")BigDecimal moduleUid) {
		System.out.println("I am in ScreenMasterListByModuleUid  Controllar moduleUid: " + moduleUid);
		List<ScreenMaster> screenMasterList = new ArrayList<ScreenMaster>();
		ScreenModule screenModule =  new ScreenModule();
		screenModule.setModuleUid(moduleUid);
		screenMasterList = screenMasterService.getScreenMasterListByModuleUid(screenModule);
		for (ScreenMaster screenMaster : screenMasterList) {
			screenMaster.setModuleUid(screenMaster.getScreenModule().getModuleUid());
		}

		return screenMasterList;
	}
	
	
//	@RequestMapping(value = "/screenMasterList/{moduleUid}")
//	public List<ScreenMaster> getScreenMasterListByModuleUid(@PathVariable(name="moduleUid")BigDecimal moduleUid) {
//		System.out.println("I am in ScreenMasterListByModuleUid  Controllar moduleUid: " + moduleUid);
//		List<ScreenMaster> screenMasterList = screenMasterService.getScreenMasterList();
//		System.out.println(" screenMasterList Size in Controller: " + screenMasterList.size());
//		System.out.println("*******************************************************");
//		for (ScreenMaster screenMaster : screenMasterList) {
//			System.out.println("screenMaster.getScreenModule().getModuleUid(): "+screenMaster.getScreenModule().getModuleUid());
//			screenMaster.setModuleUid(	screenMaster.getScreenModule().getModuleUid());
//			System.out.println(screenMaster);
//		}
//		System.out.println("*********************************************");
//
//		return screenMasterList;
//	}
	

}
