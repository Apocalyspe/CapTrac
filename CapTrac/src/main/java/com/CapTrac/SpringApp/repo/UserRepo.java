package com.CapTrac.SpringApp.repo;

import org.springframework.data.repository.CrudRepository;

import com.CapTrac.SpringApp.model.UserModel;

public interface UserRepo extends CrudRepository<UserModel, Integer>{

}
