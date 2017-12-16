package neu.edu.controller.bid;

public class BidModel {

	
	private Integer ideaid;
	private Integer price;
	private Integer rounds;
	private Byte iswined;
	private String date;
	private String des;
	private int serviceid;
	
	public Integer getIdeaid() {
		return ideaid;
	}
	public void setIdeaid(Integer ideaid) {
		this.ideaid = ideaid;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getRounds() {
		return rounds;
	}
	public void setRounds(Integer rounds) {
		this.rounds = rounds;
	}
	public Byte getIswined() {
		return iswined;
	}
	public void setIswined(Byte iswined) {
		this.iswined = iswined;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	
}
