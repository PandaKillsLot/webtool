package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Bid;


@Repository
public interface BidDao extends JpaRepository<Bid, Integer>{

}
