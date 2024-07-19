package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Diary;

@Repository
public interface DiaryRepository extends CrudRepository<Diary,Integer>{
	
	
	/*
	 * public Iterable<Diary> findAll();
	 * 
	 * public Optional<Diary> findById(int id);
	 * 
	 * public void deleteProductByID(int id);
	 * 
	 * public void deleteAll();
	 * 
	 * @SuppressWarnings("unchecked") public Diary save(Diary diary);
	 */
	
}
