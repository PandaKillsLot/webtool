package neu.edu.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import neu.edu.dao.ProjectDao;
import neu.edu.entity.Idea;
import neu.edu.entity.Project;

@Service
public class ProjectService {

	@Autowired
	public ProjectDao projectDao;
	
	// view accepted service by cate
	@Transactional
	public ArrayList<Project> findProject(int id) {
		ArrayList<Project> ans = new ArrayList<Project>();
		for (Project temp : projectDao.findAll()) {
			if (temp.getCompanyid() == id) {
				ans.add(temp);
			}
		}	
		return ans;
	}
	// update progress
		@Transactional
		public Project updateProgress(int progress, int id) {
			Project temp = projectDao.findOne(id);
			temp.setProgress(progress);
			projectDao.save(temp);
			return temp;
		}
	
}
