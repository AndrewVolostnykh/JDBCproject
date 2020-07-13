package com.example.demo.dto;

import com.example.demo.model.ToDoEntity;

import javax.validation.constraints.NotNull;

public class ToDoSaveRequest {
	public Long id;

	@NotNull
	public String text;

	public ToDoSaveRequest(){}
}