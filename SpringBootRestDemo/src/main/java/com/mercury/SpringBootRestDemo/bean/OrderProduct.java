package com.mercury.SpringBootRestDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="msi_order_product")
public class OrderProduct {
	@Id
	private int id;
	@Column
	private int qty;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnoreProperties("purchases")
	private Order order;
	@ManyToOne(fetch=FetchType.EAGER)
	//lazy loading
	@JoinColumn(name="product_id")
	private Product product;
	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderProduct(int id, int qty, Order order, Product product) {
		super();
		this.id = id;
		this.qty = qty;
		this.order = order;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", qty=" + qty + ", order=" + order + ", product=" + product + "]";
	}
	
	
}
