package com.inti;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "product_jaxb")
@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
//	@Id
	private int productid;
	private String name;
	private int quantity;
	

	public Product() {
		super();
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name= " + name + " , quantity=" + quantity + "]";
	}

	public Product(int productid, String name, int quantity) {
		super();
		this.productid = productid;
		this.name = name;
		this.quantity = quantity;
	}
	
	

}
