package com.uibs.oe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uibs.oe.model.CRMLoansDetails;

public interface LoansRepo extends JpaRepository<CRMLoansDetails, Long>{

}
