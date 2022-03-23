package com.nagarro.lms.service;

import java.util.List;

import com.nagarro.lms.entity.Book;

public interface BookService {

	List<Book> getAllBooks();
	
	Book saveBook(Book book);
	
	Book getBookByBookCode(Integer bookCode);
	
	Book updateBook(Book book);
	
	void deleteBookByBookCode(Integer bookCode);
}
