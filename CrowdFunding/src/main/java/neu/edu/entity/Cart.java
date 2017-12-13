package neu.edu.entity;
// Generated 2017-12-12 23:58:19 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cart generated by hbm2java
 */
@Entity
@Table(name = "cart", catalog = "crowdfunding")
public class Cart implements java.io.Serializable {

	private int id;
	private Integer funderid;
	private Integer ideaid;
	private Integer price;
	private Integer piece;

	public Cart() {
	}

	public Cart(int id) {
		this.id = id;
	}

	public Cart(int id, Integer funderid, Integer ideaid, Integer price, Integer piece) {
		this.id = id;
		this.funderid = funderid;
		this.ideaid = ideaid;
		this.price = price;
		this.piece = piece;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "funderid")
	public Integer getFunderid() {
		return this.funderid;
	}

	public void setFunderid(Integer funderid) {
		this.funderid = funderid;
	}

	@Column(name = "ideaid")
	public Integer getIdeaid() {
		return this.ideaid;
	}

	public void setIdeaid(Integer ideaid) {
		this.ideaid = ideaid;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "piece")
	public Integer getPiece() {
		return this.piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

}
