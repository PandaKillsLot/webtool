package neu.edu.controller.bid;

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

import neu.edu.entity.Bid;

import neu.edu.service.BidService;

@RestController
@RequestMapping("/bid")
public class BidController {

	@Autowired
	private BidService bidService;
	
	// make a bid
	@RequestMapping(path = "/{startupId}", method = RequestMethod.POST)
	public ResponseEntity<?> makeBid(@NotNull @PathVariable("startupId") int startupId,
			@NotNull @RequestBody BidModel bm) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" Something is wrong", HttpStatus.UNPROCESSABLE_ENTITY);
		Bid bd = bidService.makeBid(startupId, bm);
		if (bd != null) {
			responseEntity = new ResponseEntity<>(bd, HttpStatus.OK);
		}
		return responseEntity;
	}
	// award a bid
	@RequestMapping(path = "/{bidId}", method = RequestMethod.PUT)
	public ResponseEntity<?> awardBid(@NotNull @PathVariable("bidId") int bidId) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(" Something is wrong", HttpStatus.UNPROCESSABLE_ENTITY);
		Bid bd = bidService.awardBid(bidId);
		if (bd != null) {
			responseEntity = new ResponseEntity<>(bd, HttpStatus.OK);
		}
		return responseEntity;
	}
}
