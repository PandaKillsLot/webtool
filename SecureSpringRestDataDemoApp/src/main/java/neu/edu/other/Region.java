package neu.edu.other;
// Generated 2017-12-15 9:37:33 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Region generated by hbm2java
 */
@Entity
@Table(name = "region", catalog = "DemoApp")
public class Region implements java.io.Serializable {

	private int userid;
	private String region;

	public Region() {
	}

	public Region(int userid) {
		this.userid = userid;
	}

	public Region(int userid, String region) {
		this.userid = userid;
		this.region = region;
	}

	@Id

	@Column(name = "userid", unique = true, nullable = false)
	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Column(name = "region", length = 45)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}