package com.example.formvalidation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{firstname.not.blank}")
    @Size(min=5, max=45, message = "{name.size}")
    private String firstName;
    @NotBlank(message = "{lastname.not.blank}")
    @Size(min=5, max=45, message = "{name.size}")
    private String lastName;
    @Pattern(regexp = "0\\d{9,10}", message = "{phone}")
    private String phone;
    @Min(value = 18, message = "{age.min}")
    @Max(value = 100, message = "{age.max}")
    private int age;
    @Email(message = "{email}")
    private String email;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phone, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
