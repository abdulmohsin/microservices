package com.abdul.dbservice.repository;

import java.time.ZonedDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Just to simulate Order persistence
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "Order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column( name = "ORDER_ID")
	private String orderId;
	
	@Column( name = "acceptanceDateTime")
	private ZonedDateTime acceptanceDateTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ZonedDateTime getAcceptanceDateTime() {
		return acceptanceDateTime;
	}

	public void setAcceptanceDateTime(ZonedDateTime acceptanceDateTime) {
		this.acceptanceDateTime = acceptanceDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acceptanceDateTime, id, orderId);
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
		return Objects.equals(acceptanceDateTime, other.acceptanceDateTime) && Objects.equals(id, other.id)
				&& Objects.equals(orderId, other.orderId);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
