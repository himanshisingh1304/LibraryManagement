package com.nagarro.lms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.lms.entity.Book;
import com.nagarro.lms.repository.BookRepository;
import com.nagarro.lms.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private  BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public Book getBookByBookCode(Integer bookCode) {
		return bookRepository.findById(bookCode).get();
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteBookByBookCode(Integer bookCode) {
		bookRepository.deleteById(bookCode);
	}

	

	
}
