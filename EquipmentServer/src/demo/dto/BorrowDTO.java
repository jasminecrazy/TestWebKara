package demo.dto;

import java.util.Date;

import demo.entity.Employee;
import demo.entity.Equipment;

public class BorrowDTO {
	private Integer id;
	private String employeeId;
	private Equipment equipment;
	private Date dateBorrow;
	private Date dateReturnback;
	private int quantity;
	private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Date getDateBorrow() {
		return dateBorrow;
	}
	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}
	public Date getDateReturnback() {
		return dateReturnback;
	}
	public void setDateReturnback(Date dateReturnback) {
		this.dateReturnback = dateReturnback;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public BorrowDTO(Integer id, String employeeId, Equipment equipment, Date dateBorrow, Date dateReturnback,
			int quantity, boolean status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.equipment = equipment;
		this.dateBorrow = dateBorrow;
		this.dateReturnback = dateReturnback;
		this.quantity = quantity;
		this.status = status;
	}
	public BorrowDTO() {
		super();
	}
	
	
}
