package com.CapTrac.SpringApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CapTrac.SpringApp.model.ExpenseModel;

public interface ExpenseRepo extends JpaRepository<ExpenseModel, Integer>{

	@Query("")
	Integer findByCreds(int accountid);
}
