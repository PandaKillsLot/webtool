package neu.edu.controller.ideaservice;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.idea.IdeaCreation;
import neu.edu.entity.Idea;
import neu.edu.entity.Ideaservice;
import neu.edu.entity.*;
import neu.edu.service.IdeaService;
import neu.edu.service.Idea_Ser_vService;
import neu.edu.service.United_StartupService;


@RestController
@RequestMapping("/ideaservice")
public class IdeaServiceController {
	@Autowired
	private Idea_Ser_vService iss;
	@Autowired
	private United_StartupService uss;
	
	
	// find IdeaService by id
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.GET)
	public ResponseEntity<?> getServiceById(@NotNull @PathVariable("ideaId") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no service found", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<Ideaservice> list = iss.findServiceById(id);
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}
	// add IdeaService by id
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.PUT)
	public ResponseEntity<?>addServiceById(@NotNull @PathVariable("ideaId") int id, @NotNull @RequestBody Startupservice is) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no service found", HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = uss.addServiceById(id, is);
		if (flag) {
			responseEntity = new ResponseEntity<>("done", HttpStatus.OK);
		}
		return responseEntity;
	}	
}
