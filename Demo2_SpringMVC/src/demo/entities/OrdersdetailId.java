package demo.entities;
// Generated May 6, 2017 9:54:30 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrdersdetailId generated by hbm2java
 */
@Embeddable
public class OrdersdetailId implements java.io.Serializable {

	private int productid;
	private int ordersid;

	public OrdersdetailId() {
	}

	public OrdersdetailId(int productid, int ordersid) {
		this.productid = productid;
		this.ordersid = ordersid;
	}

	@Column(name = "productid", nullable = false)
	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Column(name = "ordersid", nullable = false)
	public int getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdersdetailId))
			return false;
		OrdersdetailId castOther = (OrdersdetailId) other;

		return (this.getProductid() == castOther.getProductid()) && (this.getOrdersid() == castOther.getOrdersid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductid();
		result = 37 * result + this.getOrdersid();
		return result;
	}

}
