package com.mercury.SpringBootRestDemo.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="msi_order")
public class Order {
	@Id
	private int id;
	@Column
	private Date purchase_date;
	@OneToMany(mappedBy = "order")
	private List<OrderProduct> purchases;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, Date purchase_date, List<OrderProduct> purchases) {
		super();
		this.id = id;
		this.purchase_date = purchase_date;
		this.purchases = purchases;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public List<OrderProduct> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<OrderProduct> purchases) {
		this.purchases = purchases;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", purchase_date=" + purchase_date + ", purchases=" + purchases + "]";
	}
	
}
