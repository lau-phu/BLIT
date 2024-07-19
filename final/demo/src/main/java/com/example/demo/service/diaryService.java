package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.StuffWorksException;
import com.example.demo.model.Diary;
import com.example.demo.model.Writer;


public interface diaryService {
	
	public List<Diary> getDiaries();
	
	public Diary saveDiary(Diary diary);
	
	public String deleteDiaryById(int id);
	
	public Diary findDiaryById(int id);
	
	
	
	
	
}
