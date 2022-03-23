package com.nagarro.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.lms.entity.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, String> {
	
	Librarian findByUsernameAndPassword(String username, String password);
}
