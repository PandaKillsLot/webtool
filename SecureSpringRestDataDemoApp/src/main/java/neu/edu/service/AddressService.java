package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.address.PersonAddressModel;
import neu.edu.controller.person.PersonModel;
import neu.edu.dao.AddressDao;
import neu.edu.dao.PersonDao;
import neu.edu.entity.Address;
import neu.edu.entity.AddressId;
import neu.edu.entity.Person;

@Service
public class AddressService {

	@Autowired
	public AddressDao addressDao;

	@Autowired
	private PersonDao personDao;

	@Transactional
	public List<PersonAddressModel> listAddress(Integer personId) {
		// TODO Auto-generated method stub
		return addressDao.findByIdPersonId(personId)
					 	 .stream()
					 	 .map(address->{
					 		PersonAddressModel temp = new PersonAddressModel();
					 		temp.setAddress(address.getAddress());
					 		temp.setType(address.getId().getType());
					 		temp.setZip(address.getZip());
					 		return temp;
					 	 })
					 	 .collect(Collectors.toList());
	}

	@Transactional
	public boolean createAddress(Integer personId, PersonAddressModel model) {
		boolean created = false;
		Person person = personDao.getOne(personId);
		if (person == null) {
			return created;
		}

		AddressId id = new AddressId(person.getPersonId(), model.getType());
		Address address = new Address(id, person, model.getAddress(), model.getZip());
		addressDao.save(address);
		created = true;

		return created;

	}

	@Transactional
	public boolean updateAddress(Integer personId, PersonAddressModel model) {

		boolean updated = false;
		Address address = addressDao.findOne(new AddressId(personId, model.getType()));
		if (address == null) {
			return updated;
		}

		address.setAddress(model.getAddress());
		address.setZip(address.getZip());

		addressDao.save(address);
		updated = true;
		
		return updated;
	}
	
	@Transactional
	public boolean deleteAddress(Integer personId,String type) {

		boolean updated = false;
		Address address = addressDao.findOne(new AddressId(personId, type));
		if (address == null) {
			return updated;
		}

		addressDao.delete(address);
		updated = true;
		
		return updated;
	}

	@Transactional
	public List<PersonAddressModel> fetchAddressDetails(Integer personId, String addressType) {
		if(addressType == null){
			return null;
		}
		Person person = personDao.findOne(personId);
		if (person == null) {
			return null;
		}

		return  person.getAddresses()
				.stream()
				.filter(address -> 
					address.getId().getType().contains(addressType)
				).map(address -> {
					PersonAddressModel temp = new PersonAddressModel();
					temp.setAddress(address.getAddress());
					temp.setType(address.getId().getType());
					temp.setZip(address.getZip());
					return temp;
		
				}).collect(Collectors.toList());

		
		
	}

}
