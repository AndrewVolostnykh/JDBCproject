package com.example.demo.service;

import com.example.demo.dto.ToDoSaveRequest;
import com.example.demo.dto.mapper.ToDoEntityToResponseMapper;
import com.example.demo.exception.ToDoNotFoundException;
import com.example.demo.model.ToDoEntity;
import com.example.demo.repository.ToDoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HomeWorkSeviceTest {

    ToDoRepository toDoRepository;

    ToDoService toDoService;


    @BeforeEach
    void setUp() {
        this.toDoRepository = mock(ToDoRepository.class);
        toDoService = new ToDoService(toDoRepository);
    }

    @AfterEach
    void deleteData() {
        toDoRepository.deleteAll();
    }

    @Test
    void whenUpdateIncorrectId_thenThrowsException() {
        ToDoSaveRequest fakeEntity = new ToDoSaveRequest();
        fakeEntity.id = 999_666L;
        fakeEntity.text = "Some incorrect words";

        assertThrows(ToDoNotFoundException.class, () -> toDoService.upsert(fakeEntity));
    }

    @Test
    void manyChanges_correctResult() throws ToDoNotFoundException {
        var nowTime = ZonedDateTime.now(ZoneOffset.UTC);

        var entityId = 3L;
        var someEnotherText = "Some another text";
        var entity = new ToDoEntity(entityId, someEnotherText);

        var saveEntity = new ToDoSaveRequest();
        saveEntity.id = entityId;
        saveEntity.text = "This is a basic text";

        when(toDoRepository.findById(anyLong())).thenAnswer(i -> {
            Long id = i.getArgument(0, Long.class);
            if (id.equals(entity.getId())) {
                return Optional.of(entity);
            } else {
                return Optional.empty();
            }
        });
        when(toDoRepository.save(ArgumentMatchers.any(ToDoEntity.class))).thenAnswer(i -> {
            ToDoEntity arg = i.getArgument(0, ToDoEntity.class);
            Long id = arg.getId();
            if (id != null) {
                if (!id.equals(entity.getId()))
                    return new ToDoEntity(id, arg.getText());
                entity.setText(arg.getText());
                return entity; //return valid result only if we get valid id
            } else {
                return new ToDoEntity(40158l, arg.getText());
            }
        });


        toDoService.upsert(saveEntity);
        toDoService.completeToDo(entityId);
        saveEntity.text = someEnotherText;
        toDoService.upsert(saveEntity);

        assertEquals(entityId, toDoService.getOne(entityId).id);
        assertEquals(someEnotherText, toDoService.getOne(entityId).text);

        toDoService.upsert(saveEntity);

        assertTrue(toDoService.getOne(entityId).completedAt.isAfter(nowTime));
    }

    @Test
    void whenUpsertOne_thenRepositoryCalled() throws ToDoNotFoundException{
        var first = new ToDoSaveRequest();
        first.id = 1L;

        var result = new ToDoEntity(first.id, null);

        when(toDoRepository.findById(anyLong())).thenReturn(Optional.of(result));

        toDoService.upsert(first);

        verify(toDoRepository, times(1)).findById(1L);
        verify(toDoRepository, times(1)).save(result);
    }

    @Test
    void whenCompleteToDoIncorrectId_thenThrowException() {
        var incorrectId = 555L;

        assertThrows(ToDoNotFoundException.class, () -> toDoService.completeToDo(incorrectId));
    }

    @Test
    void whenUpsertIncorrect_thenCallRepositoryAndThrowException() {
        var incorrectId = 321321L;
        var entity = new ToDoSaveRequest();
        entity.id = incorrectId;

        assertThrows(ToDoNotFoundException.class, () -> toDoService.upsert(entity));
    }

    @Test
    void whenGetAll_thenCallRepositoryAndCorrectAnswer() {
        var id = 9L;
        var time = ZonedDateTime.now(ZoneOffset.UTC);
        var newEntity = new ToDoEntity(id, null, time);

        var resultList = new LinkedList<ToDoEntity>();
        resultList.add(new ToDoEntity(1L, "Some text", null ));
        resultList.add(new ToDoEntity(2L, "One more some text for tests", null));

        when(toDoRepository.findAll()).thenReturn(resultList);

        var result = toDoService.getAll();
        for(int i = 0; i < result.size(); i++) {
            if(!result.get(i).id.equals(resultList.get(i).getId())
                    || !result.get(i).text.equals(resultList.get(i).getText())) {
                fail();
            }
        }

        verify(toDoRepository, times(1)).findAll();

    }

    @Test
    void whenGetCompletedAll_thenReturnCorrect() {
            //mock
            var testToDos = Arrays.asList(
                    new ToDoEntity(0l, "Test 1").completeNow(),
                    new ToDoEntity(1l, "Test 2").completeNow()
            );

            when(toDoRepository.findByCompletedAtIsNotNull()).thenReturn(testToDos);

            //call
            var todos = toDoService.getAllCompleted();

            //validate
            assertTrue(todos.size() == testToDos.size());
            for (int i = 0; i < todos.size(); i++) {
                assertThat(todos.get(i), samePropertyValuesAs(
                        ToDoEntityToResponseMapper.map(testToDos.get(i))
                ));
            }
        }
}

