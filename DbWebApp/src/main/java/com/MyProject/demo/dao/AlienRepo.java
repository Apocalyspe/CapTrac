package com.MyProject.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.MyProject.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

	
}
