package neu.edu.controller.project;

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

import neu.edu.entity.Ideaservice;
import neu.edu.entity.Project;
import neu.edu.service.ProjectService;

@RestController
@RequestMapping("/project/{startupid}")
public class ProjectController {
	
	@Autowired
	private ProjectService ps;
	
	// find accepted Service by startup_id
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAceptedServic(@NotNull @PathVariable("ideaId") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no service found", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<Project> list = ps.findProject(id);
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}
	// find accepted Service by startup_id
	@RequestMapping(path = "/{progress}", method = RequestMethod.POST)
	public ResponseEntity<?> updateProgress(@NotNull @PathVariable("progress") int progress,
			@NotNull @RequestBody int projectId) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no service found", HttpStatus.UNPROCESSABLE_ENTITY);
		Project list = ps.updateProgress(progress,projectId);
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
}
