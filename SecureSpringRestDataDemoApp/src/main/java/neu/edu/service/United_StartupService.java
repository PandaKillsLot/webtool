package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.startupinfo.StartupModel;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.StartupinfoDao;
import neu.edu.dao.StartupserviceDao;
import neu.edu.entity.Idea;
import neu.edu.entity.Startupinfo;
import neu.edu.entity.Startupservice;

@Service
public class United_StartupService {

	@Autowired
	public StartupserviceDao ssd;
	@Autowired
	public StartupinfoDao sid;
	@Autowired
	public IdeaDao ideaDao;
	
	
	
	//updateservice
	@Transactional
	public boolean  updateservice(Startupservice ss) {
		Startupservice temp = ssd.findOne(ss.getServiceId());
		if( temp == null) {
			return false;
		} else {
			//temp.s;
			temp.setCategory(ss.getCategory());
			temp.setDes(ss.getDes());
			temp.setPrice(ss.getPrice());
			temp.setIsAvailable(ss.getIsAvailable());
			temp.setReason(ss.getReason());
			ssd.save(temp);
			return true;
		}
	}
	@Transactional
	public boolean  deleteService(int id) {
		Startupservice temp = ssd.findOne(id);
		if( temp == null || temp.getCategory() != null) {
			return false;
		} else {
			
			ssd.delete(temp);
			return true;
		}
	}
	//
	@Transactional
	public ArrayList<Startupservice> findAllservice() {

		ArrayList<Startupservice> companies = (ArrayList<Startupservice>) ssd.findAll();

		return companies;
	}

	@Transactional
	public ArrayList<StartupModel> findAllStartup() {
		List<Startupinfo> infoList = sid.findAll();
		List<Startupservice> serviceList = ssd.findAll();
		ArrayList<StartupModel> companies = new ArrayList<>();

		for (Startupinfo info : infoList) {
			ArrayList<Startupservice> list = new ArrayList<>();
			for (Startupservice service : serviceList) {
				if (service.getStartupId() == info.getUserid()) {
					list.add(service);
				}
			}
			// companies.add(new StartupModel(info.getId(), info.getCompanyName(),
			// info.getCategory(),info.getDes(), list));
		}

		return companies;
	}

	// !!!!!!!!!!!!!!!!!!!!!start_up id == userid
	@Transactional
	public boolean deleteStartup(int id) {
		Startupinfo si = sid.findOne(id);
		List<Startupservice> ss = ssd.findAll();
		int count = 0;
		for (Startupservice s : ss) {
			if (s.getStartupId() == si.getUserid()) {
				count++;
			}
		}
		if (si == null || count > 0) {
			return false;
		} else {
			sid.delete(si);
			return true;
		}
	}

	@Transactional
	public boolean disableStartup(int id, String reason) {
		Startupservice ss = ssd.findOne(id);
		ss.setIsAvailable("false");
		ss.setReason(reason);
		ssd.save(ss);
		return true;
	}

	// start up register for a cate
	// using userid
	@Transactional
	public StartupModel registerCate(int id, String cate, String details) {
		Startupinfo si = null;
		for (Startupinfo temp : sid.findAll()) {
			if (temp.getUserid() == id) {
				si = temp;
			}
		}
		si.setCategory(cate);
		si.setDes(details);
		sid.save(si);

		return null;
	}

	// addServiceById
	@Transactional
	public boolean addServiceById(int id, Startupservice temp) {

		if (ideaDao.findOne(temp.getStartupId()) == null) {
			return false;
		}

		ssd.save(temp);
		return true;
	}

}
