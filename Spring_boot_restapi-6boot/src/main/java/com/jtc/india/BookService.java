package com.jtc.india;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class BookService {
private static List<Book> list=new ArrayList<>();
static {
	list.add(new Book(12,"java","som"));
	list.add(new Book(13,"python","shubham"));
     list.add(new Book(14,"c++","sumit"));
}
public List<Book> getallbook(){
	return list;
}

public Book getsinglebookbyid(int id) {
	
	  Book book=null;
	  book =list.stream().filter(e->
	  e.getId()==id).findFirst().get(); 
	  return book;
	
}

public Book addBook(Book b) {
 list.add(b);
	return  b;
}
 

public void detelebyid(int id) {
	list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
}

public void Updatebyid(Book book,int id) {
list=	list.stream().map(b->{
		if(b.getId()==id) {
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
		}
		return b;
	}).collect(Collectors.toList());
}
}
