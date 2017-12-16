package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import neu.edu.entity.*;

@Repository
public interface StartupserviceDao extends JpaRepository<Startupservice, Integer>{

}
