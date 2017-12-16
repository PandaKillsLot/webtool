package neu.edu.controller.idea;

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

import neu.edu.controller.user.UserModel;
import neu.edu.entity.Idea;

import neu.edu.service.IdeaService;

@RestController
@RequestMapping("/idea")
public class IdeaController {

	@Autowired
	private IdeaService ideaService;

	// create an idea
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createIdeas( @NotNull @RequestBody IdeaCreation ic) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("not able to creat an idea", HttpStatus.UNPROCESSABLE_ENTITY);
		Idea list = ideaService.create(ic);
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}

	// fetch all ideas
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllIdeas() {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("no idea available", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<Idea> list = null;
		list = ideaService.findAll();
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}

	// fetch all ideas funding option
	@RequestMapping(path = "/{ideaID}/fundings", method = RequestMethod.GET)
	public ResponseEntity<?> getFundingOptions(@NotNull @PathVariable("ideaID") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("no idea available", HttpStatus.UNPROCESSABLE_ENTITY);
		Funding_option fo = ideaService.getFundingOptions(id);
		if (fo != null) {
			responseEntity = new ResponseEntity<>(fo, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
	
	
	

	// find ideas by cate
	@RequestMapping(path = "/{category}", method = RequestMethod.GET)
	public ResponseEntity<?> getIdeasByCat(@NotNull @PathVariable("category") String category) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no such cate", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<Idea> list = ideaService.findIdeaByCate(category);
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}

	// delete ideas by id
	@RequestMapping(path = "/{ideaID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteIdea(@NotNull @PathVariable("ideaID") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" ideas under cate could not be delete",
				HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = ideaService.deleteIdea(id);
		if (flag) {
			responseEntity = new ResponseEntity<>("sucessful deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

	// disable ideas by id
	@RequestMapping(path = "/{ideaID}/disable", method = RequestMethod.PUT)
	public ResponseEntity<?> disableIdea(@NotNull @PathVariable("ideaID") int id, @NotNull @RequestBody String reason) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" ideas under cate could not be disabled",
				HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = ideaService.disableIdea(id, reason);
		if (flag) {
			responseEntity = new ResponseEntity<>("sucessful deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	

}
