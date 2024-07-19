package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.DiaryRepository;
import com.example.demo.dao.WriterRepository;
import com.example.demo.dao.impl.DiaryDaoImpl;
import com.example.demo.exception.DiaryNotFoundException;
import com.example.demo.exception.WriterNotFoundException;
import com.example.demo.model.Diary;
import com.example.demo.model.Writer;
import com.example.demo.model.Diary;
import com.example.demo.service.diaryService;
import com.example.demo.service.impl.WriterServiceImpl;


@Service
public class DiaryServiceImpl implements diaryService {

	@Autowired
	DiaryRepository repository;	
	@Autowired
	WriterServiceImpl writerService;

	//@GetMapping("/diaries")
	public List<Diary> getDiaries() {
		Iterable<Diary> diary = repository.findAll();
		List<Diary> list = new ArrayList<>();
		diary.forEach(list::add);
		return list;
	}
	public List<Diary> getDiariesByWriter(Writer w) {
		Iterable<Diary> diary = repository.findAll();
		List<Diary> list = new ArrayList<>();
		for(Diary d : diary) {
			if (d.getWriter().getId() == w.getId())
				list.add(d);
		}
		return list;
	}
	
	//@GetMapping("/login?username&password}")
	public Writer findUserByLogin(@RequestParam String username, @RequestParam String password) {

		Iterable<Writer> writer = writerService.findAllWriter();
		
		
		for(Writer i : writer) {
			if(i.getUsername().equals(username) && i.getPassword().equals(password)) {
				
//				List<Diary> list = new ArrayList<>();
//			
//				list = getDiariesByWriter(i);
//				i.setDiaries(list);
				return i;
			}
		}
		
		throw new WriterNotFoundException("Writer not found!! for "+ username);
		
	}
	
	//@PostMapping("/diary")
	public Diary saveDiary(@RequestBody Diary diary) {
		// TODO Auto-generated method stub
		Writer w = null;
		if(diary.getWriterID() !=0) {
			 w = writerService.findWriterById(diary.getWriterID());
		}
		diary.setWriter(w);
		
		return repository.save(diary);
	}
	
	//@GetMapping("/diary/{id}")
	public Diary findDiaryById(@PathVariable int id){
		if(repository.findById(id) != null) {
			throw new DiaryNotFoundException("diary's entry not found!! ID="+id);
		}
		return repository.findById(id).get();
	}
	
	//@PutMapping("/diary/{id}")
	public String editDiary(@PathVariable int id, @RequestBody Diary diary){
		Diary d = findDiaryById(id);
		
		d.toString();
		
		if(d.getId()!=0) {
			d.setId(id);
			if(!diary.getEntry().isEmpty())
				d.setEntry(diary.getEntry());
			if(diary.getWriter().getId()!=0) {
				Writer w = writerService.findWriterById(diary.getWriter().getId());
				d.setWriter(w);
			}
			saveDiary(d);
			return "Diary changed";
		}else {
			throw new DiaryNotFoundException("diary's entry not found!! ID="+id);
			
		}
		
	}
		
	
	//@DeleteMapping("/Diary/{id}")
	public String deleteDiaryById(@PathVariable int id){
		Diary Diary = findDiaryById(id);
		if(Diary!=null) {
			repository.deleteById(id);
			return "Diary deleted";
		}else {
			throw new DiaryNotFoundException("diary's entry not found!! ID="+id);
		}
	}




}
