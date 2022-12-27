package ua.petstore.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Product.getAllProduct", query = "SELECT p FROM Product p"),
	@NamedQuery(name = "Product.getAllProductCategory", query = "SELECT p FROM Product p WHERE p.category.id = :category") })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private double price;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Category category;
	@Column(name = "image")
	private String imageURL;

	public Product() {

	}

	public Product(String name, String description, double price, Category category, String imageURL) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.imageURL = imageURL;
	}

	public Product(int id, String name, String description, double price, Category category, String imageURL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", imageURL=" + imageURL + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, id, imageURL, name, price);
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
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(imageURL, other.imageURL) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	public String getImageURL() {
		return imageURL;
	}

	public Product setId(int id) {
		this.id = id;
		return this;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	public Product setPrice(double price) {
		this.price = price;
		return this;
	}

	public Product setCategory(Category category) {
		this.category = category;
		return this;
	}

	public Product setImageURL(String imageURL) {
		this.imageURL = imageURL;
		return this;
	}
}
