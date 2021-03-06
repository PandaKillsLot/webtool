package neu.edu.other;
// Generated 2017-12-15 9:37:33 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserStatus generated by hbm2java
 */
@Entity
@Table(name = "user_status", catalog = "DemoApp")
public class UserStatus implements java.io.Serializable {

	private int userId;
	private String disabled;
	private String reason;

	public UserStatus() {
	}

	public UserStatus(int userId) {
		this.userId = userId;
	}

	public UserStatus(int userId, String disabled, String reason) {
		this.userId = userId;
		this.disabled = disabled;
		this.reason = reason;
	}

	@Id

	@Column(name = "user_id", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "disabled", length = 45)
	public String getDisabled() {
		return this.disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	@Column(name = "reason", length = 45)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
