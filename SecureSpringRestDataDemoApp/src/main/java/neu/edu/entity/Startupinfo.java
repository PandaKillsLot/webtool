package neu.edu.entity;
// Generated 2017-12-14 14:57:06 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Startupinfo generated by hbm2java
 */
@Entity
@Table(name = "startupinfo")
public class Startupinfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Integer userid;
	private String des;
	private String category;
	private String companyName;

	public Startupinfo() {
	}

	public Startupinfo(int id) {
		this.id = id;
	}

	public Startupinfo(int id, Integer userid, String des, String category, String companyName) {
		this.id = id;
		this.userid = userid;
		this.des = des;
		this.category = category;
		this.companyName = companyName;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "des", length = 45)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Column(name = "category", length = 45)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "company name", length = 45)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
