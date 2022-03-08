package Ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import Ecommerce.model.Product;

@Service
@Transactional
public class ProductDao {
	
	private List<Product> products;
	
	public ProductDao() {		
		this.products = new ArrayList<Product>();
		this.products.add(new Product("p01", "basket 1", "photo1.gif", 20));
		this.products.add(new Product("p01", "basket 2", "photo2.gif", 21));
		this.products.add(new Product("p03", "basket 3", "photo3.gif", 22));
	}
	
	public List<Product> findAll() {
		return this.products;
	}
	
	public Product find(String id) {
		for (Product product : this.products) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}
	
}
