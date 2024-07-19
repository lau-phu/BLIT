package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Writer;


@Repository
public interface WriterRepository extends CrudRepository<Writer,Integer>{

	Writer findByName(String name);
	
//	public List<Writer> findWriter(String name);
//	
//	public Writer findById(long id);
	
	
}
