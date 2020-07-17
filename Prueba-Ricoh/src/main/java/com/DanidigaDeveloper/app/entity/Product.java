package com.DanidigaDeveloper.app.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1396909409655842783L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String description;
	
	//@Column(name="catalogueCode", nullable=false, length = 10, unique = true)
	//private String catalogueCode;
	
	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Order order;
	//@ManyToMany(cascade = CascadeType.ALL)
    //private List<Order> orders;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Catalogue catalogue;


	public Product() {
		
	}
	
	

	public Product(Long id, String description, Catalogue catalogue) {
		super();
		this.id = id;
		this.description = description;
		this.catalogue = catalogue;
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



	public Catalogue getCatalogue() {
		return catalogue;
	}



	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", catalogue=" + catalogue + "]";
	}
}
