package com.spring.taskapi.model;

import java.time.LocalDate;

import com.spring.taskapi.enums.*;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Task {
    @Id
    @Column(nullable = false,unique = true)
    private int id;
        
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private LocalDate due_date;
    
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task()
    {
        //super();
    }

    public Task(int id,String title,String description, LocalDate due_date,Priority priority, Status status)
    {
        super();
        this.id=id;
        this.title=title;
        this.description=description;
        this.due_date=due_date;
        this.priority=priority;
        this.status=status;
    }

    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id=id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public LocalDate getDue_Date()
    {
        return due_date;
    }
    public void setDue_date(LocalDate due_date)
    {
        this.due_date=due_date;
    }
    public Priority getPriority()
    {
        return priority;
    }
    public void setPriority( Priority priority)
    {
        this.priority=priority;
    }
    public Status getStatus()
    {
        return status;
    }

    public void setStatues(Status status)
    {
        this.status=status;
    }

}
