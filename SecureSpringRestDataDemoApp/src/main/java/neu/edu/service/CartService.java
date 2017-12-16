package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.dao.CartDao;

@Service
public class CartService {


	@Autowired
	public CartDao cartDao;
}
