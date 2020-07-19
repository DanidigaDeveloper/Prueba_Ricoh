package com.DanidigaDeveloper.app.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1396909409655842783L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
    private String name;
	
	@Column(length = 3, nullable = false)
    private Long price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "catalogue_id", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties("products")
	private Catalogue catalogue;

	public Product() {
		
	}
	
	public Product(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

    public Catalogue getCatalogue() {
        return catalogue;
    }


    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(getId(), product.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", catalogue=" + catalogue +
				'}';
	}
}
