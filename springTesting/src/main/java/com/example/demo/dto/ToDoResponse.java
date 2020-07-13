package com.example.demo.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

public class ToDoResponse {
	@NotNull
	public Long id;

	@NotNull
	public String text;

	public ZonedDateTime completedAt;

	public ToDoResponse() {}

	public ToDoResponse(Long id, String text, ZonedDateTime completedAt) {
		this.id = id;
		this.text = text;
		this.completedAt = completedAt;
	}
}