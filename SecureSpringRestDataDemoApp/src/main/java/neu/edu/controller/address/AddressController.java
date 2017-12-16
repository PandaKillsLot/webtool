package neu.edu.controller.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.person.PersonModel;
import neu.edu.service.AddressService;
import neu.edu.service.PersonService;

@RestController
@RequestMapping("/person/{personId:[0-9]}/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(method = RequestMethod.GET)
	public List<PersonAddressModel> listAddress(@PathVariable("personId") Integer personId) {

		return addressService.listAddress(personId);

	}
	
	@RequestMapping(path="/{addressType}", method=RequestMethod.GET)
	public List<PersonAddressModel> fetchPersonDetails(@PathVariable("personId") Integer personId,
			@PathVariable("addressType") String addressType){
		return addressService.fetchAddressDetails(personId, addressType);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createAddress(@PathVariable("personId") Integer personId, @RequestBody PersonAddressModel model) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Address Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);

		if (addressService.createAddress(personId, model)) {
			responseEntity = new ResponseEntity<>("Address Creation Success",
					HttpStatus.OK);
		}
		return responseEntity;
	}
	

	@RequestMapping(path="/{addressType}",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAddress(@PathVariable("personId") Integer personId, @PathVariable("addressType") String addressType) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Address delete Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);

		if (addressService.deleteAddress(personId, addressType)) {
			responseEntity = new ResponseEntity<>("Address delete Success",
					HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateAddress(@PathVariable("personId") Integer personId, @RequestBody PersonAddressModel model) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Address update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);

		if (addressService.updateAddress(personId, model)) {
			responseEntity = new ResponseEntity<>("Address update Success",
					HttpStatus.OK);
		}
		return responseEntity;
	}

}
