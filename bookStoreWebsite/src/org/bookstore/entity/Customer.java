package org.bookstore.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", catalog = "bookstoredb", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "SELECT customer FROM Customer customer ORDER BY customer.registerDate DESC"),
	@NamedQuery(name = "Customer.countAll", query = "SELECT Count(customer.email) FROM Customer customer"),
	@NamedQuery(name = "Customer.findByEmail", query = "SELECT customer FROM Customer customer WHERE customer.email = :email"),
	@NamedQuery(name = "Customer.checkLogin", query = "SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password")})

public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = -2440619670307420765L;
	
	private Integer customerId;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String country;
	private String phone;
	private String pincode;
	private String password;
	private Date registerDate;
	
	private Set<BookOrder> bookOrders = new HashSet(0);
	
	private Set<Review> reviews = new HashSet(0);

	
	public Customer() {
	}

	public Customer(String email, String firstName, String lastName, String address, String city, String country,
			String phone, String pincode, String password, Date registerDate) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.pincode = pincode;
		this.password = password;
		this.registerDate = registerDate;
	}

	public Customer(String email, String firstName, String lastName, String address, String city, String country,
			String phone, String pincode, String password, Date registerDate, Set bookOrders, Set reviews) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.pincode = pincode;
		this.password = password;
		this.registerDate = registerDate;
		this.bookOrders = bookOrders;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "customer_id", unique = true, nullable = false)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "firstName", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address", nullable = false, length = 128)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false, length = 32)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Country", nullable = false, length = 64)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone", nullable = false, length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "pincode", nullable = false, length = 24)
	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date", nullable = false, length = 19)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(Set<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
}