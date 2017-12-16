package neu.edu.controller.fundings;

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

import neu.edu.entity.Fundings;
import neu.edu.service.FundingsService;
import neu.edu.entity.*;


@RestController
@RequestMapping("/fundings")
public class FundingsController {
	@Autowired
	private FundingsService fs;
	
	
	// find fundings by id
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.GET)
	public ResponseEntity<?> getIdeasByCat(@NotNull @PathVariable("ideaId") int id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no fundings found", HttpStatus.UNPROCESSABLE_ENTITY);
		ArrayList<Fundings> list = fs.findById(id);
		if (list != null) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return responseEntity;
	}
	// 	creat a fundings by id( default id is one
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<?> createFindings(@NotNull @RequestBody Fundings fundings) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" no fundings found", HttpStatus.UNPROCESSABLE_ENTITY);
		boolean flag = fs.makeFundings(fundings);
		if (flag) {
			responseEntity = new ResponseEntity<>("funding made", HttpStatus.OK);
		}
		return responseEntity;
	}
	
}
