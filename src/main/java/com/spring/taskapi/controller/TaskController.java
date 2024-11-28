package com.spring.taskapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.spring.taskapi.model.Task;
import com.spring.taskapi.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.taskapi.service.TaskService;


@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
//to add a task
    @PostMapping("/task/add")
    public Task addTask(@RequestBody Task task) {
        return taskService.insert(task);
    }
//to get all tasks
@GetMapping("/task/all")
public List<Task> getAllTask() {
    List<Task> list= taskService.getAllTask();
    return list;
}

//to get task by id
@GetMapping("/task/getById/{id}")
public ResponseEntity<?> getById(@PathVariable int id) {
    Task task=taskService.validate(id);
    return ResponseEntity.ok(task);
}
//to get task by title
/*@GetMapping("/task/getByTitle/{title}")
public ResponseEntity<?> getMethodName(@PathVariable String title) {
    Task task=taskService.validate(title);
    return ResponseEntity.ok(task);
}
*/
@GetMapping("/task/getByTitle/{title}")
public ResponseEntity<?> getTaskByTitle(@PathVariable String title) {
    List<Task> tasks = taskService.validate(title);
    return ResponseEntity.ok(tasks);
}


//to update a task
@PutMapping("/task/update/{id}")
public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task newTask) {
    
    return ResponseEntity.ok(taskService.updateTask(id,newTask));
}

 /*@PutMapping("/api/books/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book bookDetails) {
        return ResponseEntity.ok(bookService.updateBook(isbn, bookDetails));
    }
*/
//delete a task
@DeleteMapping("/task/deletebyid/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable int id) 
{
    taskService.deleteTaskById(id);
    return ResponseEntity.noContent().build();
}
   
   /* @DeleteMapping("/api/books/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.deleteBookByIsbn(isbn);
        return ResponseEntity.noContent().build();
    }
*/
    
}
