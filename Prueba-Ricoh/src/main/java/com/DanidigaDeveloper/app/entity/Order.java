package com.DanidigaDeveloper.app.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.DanidigaDeveloper.app.controller.OrderController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

	@Transient
	@JsonIgnore
	private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	private static final long serialVersionUID = 4356982789128188794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String description;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItem> items = new ArrayList<OrderItem>();

	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0D;
		LOGGER.debug("[getTotalOrderPrice]: orderItems : {}", getItems());
		List<OrderItem> orderItems = getItems();
		for (OrderItem op : orderItems) {
			LOGGER.debug("[getTotalOrderPrice]: op : {} {} {}", op, op.getQuantity(), op.getProduct());
			if (op.getProduct() != null)
				sum += op.getQuantity() * op.getProduct().getPrice();
		}
		return sum;
	}
	
	public Order() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", items=" + items + "]";
	}

}
