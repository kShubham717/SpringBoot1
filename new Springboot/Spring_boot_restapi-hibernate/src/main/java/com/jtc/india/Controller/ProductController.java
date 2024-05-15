package com.jtc.india.Controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PutExchange;

import com.jtc.india.Entity.Product;
import com.jtc.india.Hibernate.ProductRepository;
import com.jtc.india.Service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
@RestController
@Validated
public class ProductController {
	
	


private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
 private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
 
 @PostMapping("/addproduct")
 public Product addproduct(@Valid @RequestBody Product product) {
	 return productService.saveProduct(product);
 }
 @Operation()
 @GetMapping("/getAll")
 public List<Product> getallproduct() {
	 return productService.getproducts();
 }
 @GetMapping("/getAll/{id}")
 public Product getbyid(@PathVariable int id) {
	 return productService.getproductById(id);
 }
 @DeleteMapping("/delete/{id}")
 public void deletebyid(@PathVariable int id) {
	 productService.deleteproducts(id);
 }
 @PutMapping("/put/{id}")
 public Product updateByid(@PathVariable int id, @RequestBody Product product) {
	 return productService.update(id,product);
 }
 //find by name
 @GetMapping("/get/{name}")
 public List<Product> getbyname(@PathVariable @jakarta.validation.constraints.NotNull String name) {
	 return productRepository.findByName(name);
}
 //custom query
 @GetMapping("/getallproduct")
 public List<Product> getall(){
	 return productRepository.getallproduct();
 }
  @GetMapping("/getbyname/{name}")
  public List<Product> productByname( @PathVariable String name){
	  return productRepository.getproductbyname(name);
  }
 //native query
  @GetMapping("/prouser")
  public List<Product> getproduct(){
	  return productRepository.getproducts();
  }
  //requestparam
 @GetMapping("/getReq")
 public Product getparam(@RequestParam int id) {
	 return productRepository.findById(id).get();
 }
	
 
 @PostMapping("/image")
 public String save(@RequestParam("file") MultipartFile[] file) {
	 System.out.println(file);
	 this.log.info("{} is created",file.length);
	 //this.log.info("name of the file",file);
	 return "success";
 }
 //namedquery
 @GetMapping("/named")
 public List<Product> getparam(@RequestParam String name) {
	 return productRepository.findByName(name);
 }
 
 
}
