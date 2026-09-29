package org.example.techie.exceptionhandlingspringbootdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_TBL")
public class User {
    @Id
    @NotNull
    private int id;
    @NotNull(message = "name should not be null")
    private String name;
    @Email(message="Email is not correct")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "Mobile number is not correct")
    private String phoneNumber;
    private int age;

    public User(String phoneNumber, String email, String name, int id, int age) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
