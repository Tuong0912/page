package com.example.jpacustomer.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Table
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer(Long id, String name, int age, Province province) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.province = province;
    }

    public Customer(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
