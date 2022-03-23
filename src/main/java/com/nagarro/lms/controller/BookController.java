package com.nagarro.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagarro.lms.entity.Book;
import com.nagarro.lms.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addbook";
		
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{bookCode}")
	public String editBook(@PathVariable Integer bookCode, Model model) {
		model.addAttribute("book", bookService.getBookByBookCode(bookCode));
		return "editbook";
	}
	
	@PostMapping("/books/{bookCode}")
	public String updateBook(@PathVariable Integer bookCode, @ModelAttribute("book") Book book, Model model) {
		Book existingBook = bookService.getBookByBookCode(bookCode);
		existingBook.setBookCode(bookCode);
		existingBook.setBookName(book.getBookName());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setDateAdded(book.getDateAdded());
		
		bookService.updateBook(existingBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookCode}")
	public String deleteBook(@PathVariable Integer bookCode) {
		bookService.deleteBookByBookCode(bookCode);
		return "redirect:/books";
	}
}
