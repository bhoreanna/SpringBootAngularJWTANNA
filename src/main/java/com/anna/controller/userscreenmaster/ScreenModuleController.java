package com.anna.controller.userscreenmaster;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anna.boinerface.userscreenmaster.ScreenModuleServiceInterface;
import com.anna.component.User;
import com.anna.component.userscreenmaster.ScreenMaster;
import com.anna.component.userscreenmaster.ScreenModule;
// 192.168.10.164:9991/screenmodule/screenModuleList
@RestController
@RequestMapping("/screenmodule")
//@CrossOrigin(origins = "http://192.168.10.165:4200", allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

//@CrossOrigin(origins = "http://192.168.10.165:8082", allowedHeaders = "*") //Tomcat
//@CrossOrigin(origins = "http://192.168.8.105:4200", allowedHeaders = "*")
public class ScreenModuleController {

	@Autowired
	 ScreenModuleServiceInterface screenModuleService;
	
	public ScreenModuleController() {
		System.out.println(" I   In ScreenModuleController: ");

	}

	
	@RequestMapping(value = "/screenModuleList")
	public List<ScreenModule> getScreenModuleList() {
		System.out.println("i am in userList in main Controllar");
		List<ScreenModule> screenModuleList = screenModuleService.getScreenModuleList();
		System.out.println("User List Size in Controller: " + screenModuleList.size());
		screenModuleList.forEach(s->System.out.println("\n before "+s.toString()));
		System.out.println("before   screenModuleList: " + screenModuleList);
		screenModuleList.forEach(s->{
			
	List<ScreenMaster> list = s.getScreenMasterList();
	Iterator<ScreenMaster> itr = list.iterator();
while (itr.hasNext()) {
	ScreenMaster screenMaster = (ScreenMaster) itr.next();
	if(screenMaster.getScreenMasterUid().intValue()==116) {
		itr.remove();
	}
}
		});
		
		screenModuleList.forEach(s->System.out.println("\n after "+s.toString()));

		return screenModuleList;
	}
	
}
