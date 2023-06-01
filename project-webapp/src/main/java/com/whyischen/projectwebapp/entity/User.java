package com.whyischen.projectwebapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
}