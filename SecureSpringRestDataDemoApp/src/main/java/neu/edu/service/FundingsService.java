package neu.edu.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.dao.FundingsDao;
import neu.edu.dao.IdeaDao;
import neu.edu.entity.Fundings;
import neu.edu.entity.Idea;
import neu.edu.entity.Ideaservice;

@Service
public class FundingsService {


	@Autowired
	public FundingsDao fundingsDao;
	@Autowired
	public IdeaDao ideaDao;
	

	@Transactional
	public ArrayList<Fundings> findById(int id) {
		ArrayList<Fundings> ori= (ArrayList<Fundings>) fundingsDao.findAll();
		ArrayList<Fundings>  ans = new ArrayList<>();
		for (Fundings f : ori) {
			if ( f.getIdeaId().equals(String.valueOf(id))) {
				ans.add(f);
			}
		}
		return ans;
	}


	@Transactional
	public boolean makeFundings(Fundings funding) {
		
		ArrayList<Fundings> ori= (ArrayList<Fundings>) fundingsDao.findAll();
		ArrayList<Fundings>  ans = new ArrayList<>();
		int count = 0;
		for (Fundings f : ori) {
			if ( f.getIdeaId().equals(String.valueOf(funding.getIdeaId()))) {
				count += f.getPrice() * f.getPiece();
			}
		}
		Idea idea = null;
		for (Idea temp :ideaDao.findAll()) {
			if (temp.getId() == Integer.valueOf(funding.getIdeaId())) {
				idea = temp;
			}
		}
		if (idea == null || idea.getTotalFunding() < count + funding.getPiece() * funding.getPiece()) {
			return false;
		}
		fundingsDao.save(funding);
		return true;
	}
	
	
}
