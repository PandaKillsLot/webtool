package neu.edu.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import neu.edu.controller.user.UserCreation;
import neu.edu.dao.IdeaserviceDao;
import neu.edu.entity.Ideaservice;
import neu.edu.entity.User;

@Service
public class Idea_Ser_vService {


	@Autowired
	public IdeaserviceDao ideaserviceDao;
	
	
	@Transactional
	public ArrayList<Ideaservice> findServiceById(int id) {
		ArrayList<Ideaservice> ori= (ArrayList<Ideaservice>) ideaserviceDao.findAll();
		ArrayList<Ideaservice> ans = new ArrayList<Ideaservice>();
		for (Ideaservice is : ori) {
			if ( is.getIdeaId() == id) {
				ans.add(is);
			}
		}
		return ans;
	}

	
}
