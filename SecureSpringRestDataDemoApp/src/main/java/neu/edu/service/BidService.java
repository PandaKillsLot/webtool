package neu.edu.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.bid.BidModel;
import neu.edu.dao.BidDao;
import neu.edu.entity.Bid;
import neu.edu.entity.Fundings;



@Service
public class BidService {
	
	@Autowired
	public BidDao bidDao;
	
	@Transactional
	public Bid makeBid(int id,BidModel bm) {
		Bid bid = new Bid(bidDao.findAll().size() + 1, id, bm.getIdeaid(), bm.getServiceid(),bm.getPrice(),1,"no", new Date().toString(), bm.getDes()); 
		bidDao.save(bid);
		//public Bid(int id, Integer companyid, Integer ideaid, Integer serviceid, Integer price, Integer rounds,
		//Byte iswined, String date, String des
		return bid;
	}
	@Transactional
	public Bid awardBid(int id) {
		Bid bid = bidDao.findOne(id);
		bid.setIswined("no");
		bidDao.save(bid);
		//public Bid(int id, Integer companyid, Integer ideaid, Integer serviceid, Integer price, Integer rounds,
		//Byte iswined, String date, String des
		return bid;
	}
}
