package ua.petstore.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "User.getUserByEmailPassword", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
		@NamedQuery(name = "User.getUserByEmail", query = "SELECT u FROM User u WHERE u.email = :email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private boolean agreement;

	public User() {
	}

	public User(String firstName, String lastName, String email, String password, String phone, boolean agreement) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.agreement = agreement;
	}

	public User(int id, String firstName, String lastName, String email, String password, String phone,
			boolean agreement) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.agreement = agreement;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", agreement=" + agreement + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agreement, email, firstName, id, lastName, password, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return agreement == other.agreement && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone);
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public boolean isAgreement() {
		return agreement;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public User setAgreement(boolean agreement) {
		this.agreement = agreement;
		return this;
	}
}
