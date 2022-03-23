package com.nagarro.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.lms.entity.Librarian;
import com.nagarro.lms.repository.LibrarianRepository;
import com.nagarro.lms.service.LibrarainService;

@Service
public class LibrarianServiceImpl implements LibrarainService {
	
	@Autowired
	private LibrarianRepository librarianRepository;

	public Librarian login(String username, String password) {
		Librarian librarian = librarianRepository.findByUsernameAndPassword(username, password);
		return librarian;
	}

}
