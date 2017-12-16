package neu.edu.controller.startupinfo;

import java.util.ArrayList;

import neu.edu.entity.Startupservice;

public class StartupModel {
	private int id;
	private String name;
	private String cate;
	private String des;
	private ArrayList<Startupservice> serviceList;
	
	public StartupModel(int id, String name, String cate, String des,
			ArrayList<Startupservice> serviceList) {
		this.id =  id;
		this.name = name;
		this.cate = cate;
		this.des = des ;
		this.serviceList = serviceList;
	}
	
	
	
	// project ?
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public ArrayList<Startupservice> getServiceList() {
		return serviceList;
	}
	public void setServiceList(ArrayList<Startupservice> serviceList) {
		this.serviceList = serviceList;
	}
	
	
	
	
}
