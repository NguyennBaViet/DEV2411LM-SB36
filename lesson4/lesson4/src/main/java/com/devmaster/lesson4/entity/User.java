package com.devmaster.lesson4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class User {
     private String name;
     private String email;
     private int age;

     public User() {
     }

     public User(String name, String email, int age) {
          this.name = name;
          this.email = email;
          this.age = age;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
     }
}
