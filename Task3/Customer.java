package com.example;
import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    Customer(){}
    Customer(String name,String email){
        this.name=name;
        this.email=email;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name ;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email ;
    }
}
