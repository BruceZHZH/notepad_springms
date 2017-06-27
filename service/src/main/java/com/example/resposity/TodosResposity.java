package com.example.resposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TodosEntity;

public interface TodosResposity extends JpaRepository<TodosEntity, Integer>{

	List<TodosEntity>findByName(String name);
	void deleteAllByName(String name);
}
