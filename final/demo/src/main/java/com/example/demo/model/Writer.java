package com.example.demo.model;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.demo.dao.WriterRepository;
import com.example.demo.service.impl.WriterServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = new Random().nextInt(1,1000000);
	private String name;
	@Column(unique=true)
	private String username;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "writer")
	//@JsonIgnore
	private List<Diary> diaries;
	
	
//	
//	public int random() {
//		int id = new Random().nextInt(1,1000000);
//		
//		boolean exists = true;
//		while(exists) {
//			exists = w.exist(id);
//		}
//		return id;
//	}
	

	
	public Writer(String name, String password, List<Diary> diaries) {
		this.name = name;
		this.password = password;
		this.diaries = diaries;
	}

	public Writer(int id, String name, String password, List<Diary> diaries) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.diaries = diaries;
	}
	


	
}
