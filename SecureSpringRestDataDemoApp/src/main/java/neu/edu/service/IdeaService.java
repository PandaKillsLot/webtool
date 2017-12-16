package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.idea.Funding_option;
import neu.edu.controller.idea.IdeaCreation;
import neu.edu.controller.user.UserCreation;
import neu.edu.dao.IdeaDao;
import neu.edu.entity.Idea;
import neu.edu.entity.User;

@Service
public class IdeaService {


	@Autowired
	public IdeaDao ideaDao;
	
	// return all
	@Transactional
	public ArrayList<Idea> findAll() {
		return (ArrayList<Idea>) ideaDao.findAll();
	}
	// return by cate
	@Transactional
	public ArrayList<Idea> findIdeaByCate(String cate) {
		List<Idea> list = ideaDao.findAll();
		ArrayList<Idea> ans = new ArrayList<Idea>();
		for (Idea idea : list) {
			if(idea.getCategory().equals(cate)) {
				ans.add(idea);
			}
		}
		return ans;
	}
	// delete by id
	@Transactional
	public boolean deleteIdea(int id) {
		// is there ?
		Idea idea = ideaDao.findOne(id);
		if (idea == null) {
			return false;
		}
		// has cate?
		if (idea.getCategory() != null) {
			return false;
		} else {
			ideaDao.delete(id);
			return true;
		}
	}
	// disable by id
	@Transactional
	public boolean disableIdea(int id,String reason) {
		// is there ?
		Idea idea = ideaDao.findOne(id);
		if (idea == null || idea.getCategory() != null) {
			return false;
		} else {
			idea.setIsActived("yes");
			idea.setReson(reason);
			ideaDao.save(idea);
			return true;
		}
		
	}
	
	
	// create
	@Transactional
	public Idea create(IdeaCreation ic) {
		
		Idea idea = new Idea();
		idea.setId(ideaDao.findAll().size()+1);
		idea.setUserId(ic.getUserId());
		idea.setName(ic.getName());
		idea.setDes(ic.getDes());
		idea.setCreateDate(ic.getDate());
		idea.setCategory(ic.getCategory());
		idea.setDuration(String.valueOf(ic.getDuatrion()));
		idea.setTotalFunding(ic.getAmount());
		idea.setPrice(ic.getPrice());
		idea.setPieceRemain(ic.getPiece());
		
		ideaDao.save(idea);
		return idea;
	}
	
	// get funding options
	@Transactional
	public Funding_option getFundingOptions(int id) {
		Idea idea = ideaDao.getOne(id);
		Funding_option op = new Funding_option();
		
		op.setAvailble_piece(idea.getPieceRemain() / idea.getPrice());
		op.setPiece(idea.getPieceRemain());
		op.setPrice(idea.getPrice());
		return op;
		
	}
		
	
	
	
	
	
}
