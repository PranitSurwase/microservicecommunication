package com.edusol.customer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMapping;

/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
*/

@Entity
@Table(name = "customers")
/*
 * @Getter
 * 
 * @Setter
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @ToString
 */
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "cust_id")
	private int c_id;
	@Column(name = "cust_name")
	private String c_name;
	@Column(name = "cust_city")
	private String city;
	
	
//	
	//@Column
	//@ElementCollection(targetClass = Product.class)
//	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "cus_id", referencedColumnName = "c_id")
	
//	@ElementCollection
//	List<Product> por = new ArrayList<>();

	public Customer() {
		super();
	}

	/*
	 * public Customer(int c_id, String c_name, String city, List<Product> por) {
	 * super(); this.c_id = c_id; this.c_name = c_name; this.city = city;
	 * 
	 * }
	 */

	
	public int getC_id() {
		return c_id;
	}

	public Customer(int c_id, String c_name, String city) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.city = city;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", city=" + city + "]";
	}
	
	
	
}
