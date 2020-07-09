package com.CapTrac.SpringApp.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.CapTrac.SpringApp.model.ExpenseModel;

public interface ExpenseRepo extends JpaRepository<ExpenseModel, Integer>{

	@Query("")
	Integer findByCreds(int accountid);

	@Transactional
	@Modifying
	@Query("update ExpenseModel set creds_accountid = ?1 where transacid = ?2")
	void saveCredsaccountid(int id,String tm);
	
	
}
