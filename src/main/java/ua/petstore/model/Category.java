package ua.petstore.model;

import java.util.Objects;

public class Category {
	private int id;
	private String url;
	private String name;
	private String icon;
	
	public Category() {

	}

	public Category(String url, String name, String icon) {
		this.url = url;
		this.name = name;
		this.icon = icon;
	}

	public Category(int id, String url, String name, String icon) {
		this.id = id;
		this.url = url;
		this.name = name;
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", url=" + url + ", name=" + name + ", icon=" + icon + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(icon, id, name, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(icon, other.icon) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(url, other.url);
	}

	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public String getIcon() {
		return icon;
	}

	public Category setId(int id) {
		this.id = id;
		return this;
	}

	public Category setUrl(String url) {
		this.url = url;
		return this;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	public Category setIcon(String icon) {
		this.icon = icon;
		return this;
	}
}
