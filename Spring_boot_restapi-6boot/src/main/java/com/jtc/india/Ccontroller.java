package com.jtc.india;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController
public class Ccontroller {
	@Autowired
private BookService boservice;
	
@GetMapping("/books")
public List<Book> getbooks() {
	return this.boservice.getallbook();	
}
@GetMapping("/books/{id}")
public Book getbook(@PathVariable("id") int id) {
	return this.boservice.getsinglebookbyid(id);
}
@PostMapping("/books")
public Book addbook(@RequestBody Book book) {
   Book b= this.boservice.addBook(book);
   return b;
}

@DeleteMapping("/books/{id}")
public void deletebook(@PathVariable("id") int id) {
	this.boservice.detelebyid(id);
}

@PutMapping("/books/{id}")
public Book updatebook(@RequestBody Book book,@PathVariable("id") int id) {
	this.boservice.Updatebyid(book, id);
	return book;
}
}
