package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

}
