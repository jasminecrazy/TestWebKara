package demo.entity;
// Generated Jul 17, 2017 11:35:07 AM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Borrow generated by hbm2java
 */
@Entity
@Table(name = "borrow", catalog = "db_equipment")
public class Borrow implements java.io.Serializable {

	private BorrowId id;
	private Date dateBorrow;
	private Date dateLendback;
	private int quantity;

	public Borrow() {
	}

	public Borrow(BorrowId id, Date dateBorrow, Date dateLendback, int quantity) {
		this.id = id;
		this.dateBorrow = dateBorrow;
		this.dateLendback = dateLendback;
		this.quantity = quantity;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "employeeId", column = @Column(name = "employee_id", nullable = false)),
			@AttributeOverride(name = "equipmentId", column = @Column(name = "equipment_id", nullable = false)) })
	public BorrowId getId() {
		return this.id;
	}

	public void setId(BorrowId id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_borrow", nullable = false, length = 0)
	public Date getDateBorrow() {
		return this.dateBorrow;
	}

	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_lendback", nullable = false, length = 0)
	public Date getDateLendback() {
		return this.dateLendback;
	}

	public void setDateLendback(Date dateLendback) {
		this.dateLendback = dateLendback;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
