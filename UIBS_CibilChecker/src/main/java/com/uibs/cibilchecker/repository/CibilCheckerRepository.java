package com.uibs.cibilchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uibs.cibilchecker.model.User;

public interface CibilCheckerRepository extends JpaRepository<User, Long>{

	
}
