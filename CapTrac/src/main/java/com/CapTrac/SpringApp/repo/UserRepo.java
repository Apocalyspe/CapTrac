package com.CapTrac.SpringApp.repo;



import org.springframework.data.repository.CrudRepository;

import com.CapTrac.SpringApp.model.CredentialManager;

public interface UserRepo extends CrudRepository<CredentialManager, Integer>{

	
	boolean existsByUsername(String username);
	boolean existsByPassword(String password);
	
	
	
}
