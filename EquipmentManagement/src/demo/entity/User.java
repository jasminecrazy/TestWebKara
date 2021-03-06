package demo.entity;
// Generated Jul 18, 2017 11:37:46 AM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * User generated by hbm2java
 */

@Entity
@Table(name = "user", catalog = "db_equipment")
public class User implements java.io.Serializable {

	private Integer id;
	private Role role;
	@NotEmpty
	private String username;
	private String password;
	private boolean enabled;
	private String employeeId;
	private String employeeName;
	private String email;
	private Set<Borrow> borrows = new HashSet<Borrow>(0);

	public User() {
	}

	public User(Role role, String username, String password, boolean enabled, String employeeId) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.employeeId = employeeId;
	}

	public User(Role role, String username, String password, boolean enabled, String employeeId, String employeeName,
			String email, Set<Borrow> borrows) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.borrows = borrows;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "username", nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "employee_id", nullable = false, length = 50)
	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "employee_name", length = 100)
	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "email", length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Borrow> getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

}
