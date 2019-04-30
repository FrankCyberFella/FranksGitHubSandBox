package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Todo;

public interface TodoDao {

	List<Todo> getTodosForList(Long id);

}
