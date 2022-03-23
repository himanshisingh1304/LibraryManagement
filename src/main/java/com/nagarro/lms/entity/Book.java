package com.nagarro.lms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "books", schema = "lms")
public class Book {

	@Id
	private int bookCode;
	private String bookName;
	private String author;
	
	@Temporal(TemporalType.DATE)
	private Date dateAdded = new Date(System.currentTimeMillis());
	
	public Book() {
	}

	public Book(int bookCode, String bookName, String author, Date dateAdded) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.dateAdded = dateAdded;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author + ", dateAdded="
				+ dateAdded + "]";
	}
	
	
	
	
}
