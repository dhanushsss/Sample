package com.dhanushs.customer;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Customer{

    @jakarta.persistence.Id
    @SequenceGenerator(
            name = "customer_id_sequence" ,
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer Id;
    private String Name;
    private String Email;
    private Integer Age ;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, Integer age) {
        Id = id;
        Name = name;
        Email = email;
        Age = age;
    }

    public Customer(String name, String email, Integer age) {
        Name = name;
        Email = email;
        Age = age;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getAge(), customer.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getAge());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                '}';
    }
}