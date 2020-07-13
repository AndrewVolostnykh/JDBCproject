package com.example.demo.repository;

import com.example.demo.model.ToDoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    List<ToDoEntity> findByCompletedAtIsNotNull();
}