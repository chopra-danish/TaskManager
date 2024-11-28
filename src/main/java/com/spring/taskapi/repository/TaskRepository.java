package com.spring.taskapi.repository;




import com.spring.taskapi.model.Task;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> { 

    @Query("SELECT t FROM Task t WHERE t.title = :title")
    List<Task> findByTitle(String title);
}
