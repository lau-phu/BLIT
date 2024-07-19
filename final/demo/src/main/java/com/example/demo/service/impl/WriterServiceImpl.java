package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
import com.example.demo.exception.DiaryNotFoundException;
import com.example.demo.exception.StuffWorksException;
import com.example.demo.exception.WriterNotFoundException;
import com.example.demo.model.Diary;
import com.example.demo.model.Writer;
import com.example.demo.service.writerService;




@Service
public class WriterServiceImpl implements writerService{

	
	@Autowired
	WriterRepository repository;

	//@GetMapping("/writers")
	public List<Writer> findAllWriter() {
		
		Iterable<Writer> writer = repository.findAll();
		List<Writer> list = new ArrayList<>();
		writer.forEach(list::add);
		return list;
	}
	
	//@PostMapping("/writer")
	public Writer saveWriter(Writer writer) {
		// TODO Auto-generated method stub
		
		if(repository.findById(writer.getId()).isEmpty())
			return repository.save(writer);
		else {
			writer.setId(new Random().nextInt());
			saveWriter(writer);
		}
		return null;
	}
	
	//@GetMapping("/writer/{id}")
	public Writer findWriterById(@PathVariable int id){
		if(repository.findById(id).isEmpty()) {
			throw new WriterNotFoundException("Writer not found!! ID="+id);
		}
		Writer w = new Writer();
		
		w = repository.findById(id).get();
		return w;
	}

	//@GetMapping("/writers/{name}")
	public List<Writer> findWriter(@PathVariable String name){
		Iterable<Writer> writer = repository.findAll();
		List<Writer> list = new ArrayList<>();
		
		for(Writer i : writer) {
			if(i.getName().equals(name))
				list.add(i);
		}
		if(list.isEmpty()) {
			throw new WriterNotFoundException("Writer not found!! name="+name);
		}
		return list;
	}
	
	//@PutMapping("/writer/{id}")
	public String editWriter(@PathVariable int id, @RequestBody Writer writer){
		Writer w = findWriterById(id);
		if(w!=null) {
			writer.setId(id);
			saveWriter(writer);
			return "writer changed";
		}else {
			throw new WriterNotFoundException("Writer not found!! ID="+id);
		}
	}
	
	//@DeleteMapping("/writer/{id}")
	public String deleteWriterById(@PathVariable int id){
		Writer writer = findWriterById(id);
		if(writer!=null) {
			repository.deleteById(id);
			return "writer deleted";
		}else {
			throw new WriterNotFoundException("Writer not found!! ID="+id);
		}
	}


}
