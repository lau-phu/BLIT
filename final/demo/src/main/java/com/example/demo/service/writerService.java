package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.StuffWorksException;
import com.example.demo.model.Writer;


public interface writerService {
	
	public List<Writer> findAllWriter() throws StuffWorksException;
	
	public List<Writer> findWriter(String name) throws StuffWorksException;
	
	public Writer saveWriter(Writer writer)throws StuffWorksException;
	
	public String deleteWriterById(int id)throws StuffWorksException;
	
	public Writer findWriterById(int id)throws StuffWorksException;

}
