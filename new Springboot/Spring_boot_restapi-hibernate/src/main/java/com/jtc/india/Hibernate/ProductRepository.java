package com.jtc.india.Hibernate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jtc.india.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name) ;
	//jpql
	@Query("select u from Product u")
	public List<Product> getallproduct();
	@Query("select u from Product u where u.name=:n")
	public List<Product> getproductbyname(@Param("n") String name);
	
	//native query
	@Query(value="select * from product_table1",nativeQuery = true)
	public List<Product> getproducts();
	
	
}
