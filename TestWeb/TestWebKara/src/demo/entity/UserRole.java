package demo.entity;
// Generated Jul 2, 2017 3:27:07 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserRole generated by hbm2java
 */
@Entity
@Table(name = "user_role", catalog = "db_kara")
public class UserRole implements java.io.Serializable {

	private UserRoleId id;
	private Role role;
	private User user;

	public UserRole() {
	}

	public UserRole(UserRoleId id, Role role, User user) {
		this.id = id;
		this.role = role;
		this.user = user;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "userid", column = @Column(name = "userid", nullable = false)),
			@AttributeOverride(name = "roleid", column = @Column(name = "roleid", nullable = false)),
			@AttributeOverride(name = "enabled", column = @Column(name = "enabled", nullable = false)) })
	public UserRoleId getId() {
		return this.id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
