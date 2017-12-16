package neu.edu.controller.startupinfo;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.dao.StartupinfoDao;
import neu.edu.dao.StartupserviceDao;
import neu.edu.entity.Idea;
import neu.edu.entity.Startupservice;
import neu.edu.service.United_StartupService;

@RestController
@RequestMapping("/startup")
public class StartupController {
	@Autowired
	public United_StartupService uss;

	// fetch all startup & service
	@RequestMapping(path = "/model",method = RequestMethod.GET)
	public ResponseEntity<?> getAllStartups() {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("no idea available", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<StartupModel> list = uss.findAllStartup();
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}
	// fetch service
	@RequestMapping(path = "/service",method = RequestMethod.GET)
	public ResponseEntity<?> getAllServices() {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("no service available", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<Startupservice> list = uss.findAllservice();
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}
	// delete service
	@RequestMapping(path = "/service/{serviceid}",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteServices(@NotNull @PathVariable("serviceid") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("update failture", HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = uss.deleteService(id);
		if (flag) {
			responseEntity = new ResponseEntity<>("Update done", HttpStatus.OK);
		}
		return responseEntity;
	}
	// disable(update) service
	@RequestMapping(path = "/service/disable/{serviceid}",method = RequestMethod.PUT)
	public ResponseEntity<?> updateServices(@NotNull @PathVariable("serviceid") int id,
			@NotNull @RequestBody Startupservice ss) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("update failture", HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = uss.updateservice(ss);
		if (flag) {
			responseEntity = new ResponseEntity<>("Update done", HttpStatus.OK);
		}
		return responseEntity;
	}



	// delete startup by id
	@RequestMapping(path = "/{startupID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStartup(@NotNull @PathVariable("startupID") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" startup under cate could not be delete",
				HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = uss.deleteStartup(id);
		if (flag) {
			responseEntity = new ResponseEntity<>("sucessful deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

	// disable startup by id & reson
	@RequestMapping(path = "/{startupID}/disable", method = RequestMethod.PUT)
	public ResponseEntity<?> disableStartup(@NotNull @PathVariable("startupID") int id,
			@NotNull @RequestBody String reason) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" startup under cate could not be disabled",
				HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = uss.disableStartup(id, reason);
		if (flag) {
			responseEntity = new ResponseEntity<>("sucessful deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

	// resgistration startup by cate
	@RequestMapping(path = "/{startupID}/registration/{cate}", method = RequestMethod.PUT)
	public ResponseEntity<?> registrationCate(@NotNull @PathVariable("startupID") int id,
			@NotNull @PathVariable("cate") String cate, @NotNull @RequestBody String details) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" start-up not found under cate could not be disabled",
				HttpStatus.UNPROCESSABLE_ENTITY);
		StartupModel sm = uss.registerCate(id, cate, details);
		if (sm != null) {
			responseEntity = new ResponseEntity<>(sm, HttpStatus.OK);
		}
				
		return responseEntity;

	}

}
