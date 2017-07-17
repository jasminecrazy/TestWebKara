package demo.entity;
// Generated Jul 17, 2017 3:46:42 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "db_equipment")
public class Employee implements java.io.Serializable {

	private Integer id;
	private String employeeId;
	private String employeeName;
	private String email;
	private String phone;
	private Set<Borrow> borrows = new HashSet<Borrow>(0);

	public Employee() {
	}

	public Employee(String employeeId, String employeeName, String email, String phone) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
	}

	public Employee(String employeeId, String employeeName, String email, String phone, Set<Borrow> borrows) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
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

	@Column(name = "employee_id", nullable = false, length = 50)
	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "employee_name", nullable = false, length = 100)
	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "email", nullable = false, length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false, length = 250)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Borrow> getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

}
