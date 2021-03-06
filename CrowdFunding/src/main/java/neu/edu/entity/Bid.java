package neu.edu.entity;
// Generated 2017-12-12 23:58:19 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bid generated by hbm2java
 */
@Entity
@Table(name = "bid", catalog = "crowdfunding")
public class Bid implements java.io.Serializable {

	private int id;
	private Integer companyid;
	private Integer ideaid;
	private Integer serviceid;
	private Integer price;
	private Integer rounds;
	private Byte iswined;
	private String date;

	public Bid() {
	}

	public Bid(int id) {
		this.id = id;
	}

	public Bid(int id, Integer companyid, Integer ideaid, Integer serviceid, Integer price, Integer rounds,
			Byte iswined, String date) {
		this.id = id;
		this.companyid = companyid;
		this.ideaid = ideaid;
		this.serviceid = serviceid;
		this.price = price;
		this.rounds = rounds;
		this.iswined = iswined;
		this.date = date;
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

	@Column(name = "iswined")
	public Byte getIswined() {
		return this.iswined;
	}

	public void setIswined(Byte iswined) {
		this.iswined = iswined;
	}

	@Column(name = "date", length = 45)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
