package neu.edu.other;
// Generated 2017-12-15 9:37:33 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Fundings generated by hbm2java
 */
@Entity
@Table(name = "fundings", catalog = "DemoApp")
public class Fundings implements java.io.Serializable {

	private int fundId;
	private String date;
	private Integer ideaId;
	private Integer funderId;
	private Integer price;
	private String paymentMethod;
	private Integer piece;

	public Fundings() {
	}

	public Fundings(int fundId) {
		this.fundId = fundId;
	}

	public Fundings(int fundId, String date, Integer ideaId, Integer funderId, Integer price, String paymentMethod,
			Integer piece) {
		this.fundId = fundId;
		this.date = date;
		this.ideaId = ideaId;
		this.funderId = funderId;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.piece = piece;
	}

	@Id

	@Column(name = "fund_id", unique = true, nullable = false)
	public int getFundId() {
		return this.fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	@Column(name = "date", length = 45)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "idea_id")
	public Integer getIdeaId() {
		return this.ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	@Column(name = "funder_id")
	public Integer getFunderId() {
		return this.funderId;
	}

	public void setFunderId(Integer funderId) {
		this.funderId = funderId;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "payment_method", length = 50)
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(name = "piece")
	public Integer getPiece() {
		return this.piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

}
