package Ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Product product;
	private int quantity;
	
	public Item(Product find, int i) {
		// TODO Auto-generated constructor stub
	}
	public int getIdItem() {
		return id;
	}
	public void setIdItem(int idItem) {
		this.id = idItem;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
}
