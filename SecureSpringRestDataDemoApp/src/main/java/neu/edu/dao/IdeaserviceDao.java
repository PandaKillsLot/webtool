package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Ideaservice;

@Repository

public interface IdeaserviceDao extends JpaRepository<Ideaservice, Integer>{

}
