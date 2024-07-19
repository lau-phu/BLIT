package com.example.demo.controller;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Diary;
import com.example.demo.model.Writer;
import com.example.demo.service.impl.DiaryServiceImpl;
import com.example.demo.service.impl.WriterServiceImpl;


@RestController
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class Controller {

	@Autowired
	DiaryServiceImpl diaryService;
	
	@Autowired
	WriterServiceImpl writerService;
	
	
	@PostMapping("/login")
	public ResponseEntity<Writer> findUserByLogin(@RequestParam String username, @RequestParam String password) {
		return new ResponseEntity<>(diaryService.findUserByLogin(username,password),HttpStatus.OK);
		
	}
	
	@GetMapping("/diaries")
	public ResponseEntity<List<Diary>> getDiaries() {
		return new ResponseEntity<>(diaryService.getDiaries(),HttpStatus.OK);
		
	}
	
	@GetMapping("/writers")
	public ResponseEntity<List<Writer>> getWriters() {
		return new ResponseEntity<>(writerService.findAllWriter(),HttpStatus.OK);
		
	}
	
	@PostMapping("/writer")
	public ResponseEntity<Writer> saveWriter(@RequestBody Writer writer) {
		return new ResponseEntity<>(writerService.saveWriter(writer),HttpStatus.CREATED);
		
	}
	

	@PostMapping("/diary")
	public ResponseEntity<Diary> saveDiary(@RequestBody Diary diary) {
		return new ResponseEntity<>(diaryService.saveDiary(diary), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/diary/{id}")
	public ResponseEntity<Diary> getDiaryById(@PathVariable int id) {
		return new ResponseEntity<>(diaryService.findDiaryById(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/writer/{id}")
	public ResponseEntity<Writer> getWriterById(@PathVariable int id) {
		return new ResponseEntity<>(writerService.findWriterById(id), HttpStatus.OK);
		
	}

	
	  @GetMapping("/writers/{name}") 
	  public ResponseEntity<List<Writer>> getWriterByName(@PathVariable String name) { 
		  return new ResponseEntity<>(writerService.findWriter(name), HttpStatus.OK);
	  }
	 
	
	@DeleteMapping("/diary/{id}")
	public ResponseEntity<String> deleteDiaryById(@PathVariable int id) {
		return new ResponseEntity<>(diaryService.deleteDiaryById(id), HttpStatus.OK);
			
			
	}
	

	@DeleteMapping("/writer/{id}")
	public ResponseEntity<String> deleteWriterById(@PathVariable int id) {
		 return new ResponseEntity<>(writerService.deleteWriterById(id), HttpStatus.OK);
	}
	
	 @PutMapping("/diary/{id}")
	    public ResponseEntity<String> updateDiary(@PathVariable int id, @RequestBody Diary diary){
	        return new ResponseEntity<>(diaryService.editDiary(id,diary),HttpStatus.ACCEPTED);
	    }
	
	 @PutMapping("/writer/{id}")
	    public ResponseEntity<String> updateWriter(@PathVariable int id, @RequestBody Writer writer){
	        return new ResponseEntity<>(writerService.editWriter(id,writer),HttpStatus.ACCEPTED);
	    }
	





}
