package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.controller.address.PersonAddressModel;
import neu.edu.entity.Address;
import neu.edu.entity.AddressId;

@Repository
public interface AddressDao extends JpaRepository<Address, AddressId>{

	List<Address> findByIdPersonId(Integer personId);

}
