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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Proxy;

/**
 * Equipment generated by hbm2java
 */
@Entity
@Proxy(lazy = false)
@Table(name = "equipment", catalog = "db_equipment")
public class Equipment implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String equipmentId;
	private String equipmentName;
	private String status;
	private int quantity;
	private String unit;
	private Set<Borrow> borrows = new HashSet<Borrow>(0);

	public Equipment() {
	}

	public Equipment(Category category, String equipmentId, String equipmentName, int quantity, String unit) {
		this.category = category;
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.quantity = quantity;
		this.unit = unit;
	}

	public Equipment(Category category, String equipmentId, String equipmentName, String status, int quantity,
			String unit, Set<Borrow> borrows) {
		this.category = category;
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.status = status;
		this.quantity = quantity;
		this.unit = unit;
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
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "equipment_id", nullable = false, length = 100)
	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	@Column(name = "equipment_name", nullable = false, length = 100)
	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "status", length = 250)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "unit", nullable = false, length = 100)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment")
	public Set<Borrow> getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

}
