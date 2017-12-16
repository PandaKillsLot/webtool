package neu.edu.other;
// Generated 2017-12-15 9:37:33 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bid generated by hbm2java
 */
@Entity
@Table(name = "bid", catalog = "DemoApp")
public class Bid implements java.io.Serializable {

	private int id;
	private Integer companyid;
	private Integer ideaid;
	private Integer serviceid;
	private Integer price;
	private Integer rounds;
	private String iswined;
	private String date;
	private String des;

	public Bid() {
	}

	public Bid(int id) {
		this.id = id;
	}

	public Bid(int id, Integer companyid, Integer ideaid, Integer serviceid, Integer price, Integer rounds,
			String iswined, String date, String des) {
		this.id = id;
		this.companyid = companyid;
		this.ideaid = ideaid;
		this.serviceid = serviceid;
		this.price = price;
		this.rounds = rounds;
		this.iswined = iswined;
		this.date = date;
		this.des = des;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "companyid")
	public Integer getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	@Column(name = "ideaid")
	public Integer getIdeaid() {
		return this.ideaid;
	}

	public void setIdeaid(Integer ideaid) {
		this.ideaid = ideaid;
	}

	@Column(name = "serviceid")
	public Integer getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "rounds")
	public Integer getRounds() {
		return this.rounds;
	}

	public void setRounds(Integer rounds) {
		this.rounds = rounds;
	}

	@Column(name = "iswined", length = 45)
	public String getIswined() {
		return this.iswined;
	}

	public void setIswined(String iswined) {
		this.iswined = iswined;
	}

	@Column(name = "date", length = 45)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "des", length = 45)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
