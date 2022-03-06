package br.com.cauelopesmarques.course.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cauelopesmarques.course.models.enums.OrderStatus;

@Entity
@Table(name= "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@Column(name = "ORDER_STATUS")
	private Integer os;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus os, User client) {
		this.id = id;
		this.moment = moment;
		setOs(os);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id > 0) {
			this.id = id;
		}
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		if(moment != null) {
			this.moment = moment;
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		if(client != null) {
			this.client = client;
		}
	}
	
	public OrderStatus getOs() {
		return OrderStatus.valueOf(os);
	}

	public void setOs(OrderStatus os) {
		if(os != null) {
			this.os = os.getCode();
		}
	}

	public Set<OrderItem> getItems() {
		return this.items;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(OrderItem i : this.items) {
			total += i.getSubTotal();
		}
		
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
	
}
