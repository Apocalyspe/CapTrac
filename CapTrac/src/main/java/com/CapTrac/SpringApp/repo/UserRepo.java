package com.CapTrac.SpringApp.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.CapTrac.SpringApp.model.CredentialManager;

public interface UserRepo extends JpaRepository<CredentialManager, Integer>{

	
	//boolean existsByUsername(String username);
	//boolean existsByPassword(String password);
	
	//CredentialManager findByUsername(String username);
	
	
	
}
