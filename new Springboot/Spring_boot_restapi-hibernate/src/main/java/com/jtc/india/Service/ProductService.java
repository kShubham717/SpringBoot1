package com.jtc.india.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtc.india.Entity.Product;
import com.jtc.india.Hibernate.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository prorepo;
	
	public Product saveProduct(Product product) {
		return prorepo.save(product);
	}
	
	public List<Product> saveproducts( List<Product> products){
		return prorepo.saveAll(products);
	}
	public List<Product> getproducts(){
		return prorepo.findAll();
	}
	public Product getproductById(int id) {
		return prorepo.findById(id).orElse(null);
	}

	/*
	 * public Product getproductByName(String name) { return
	 * prorepo.findByName(name); }
	 */
	public void deleteproducts(int id) {
	    prorepo.deleteById(id);
	}
	
	public Product update(int id ,Product product) {
		Product pro= prorepo.findById(id).get();
		pro.setName(product.getName());
		pro.setPrice(product.getPrice());
		pro.setQuantity(product.getQuantity());
		prorepo.save(product);
		return pro;
	}
}
