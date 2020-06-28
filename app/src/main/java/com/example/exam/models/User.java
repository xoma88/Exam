package com.example.exam.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    Integer id;
    String Name;
    String Email;
    Integer[] imageId;
    String Login;
    String Password;
    Boolean Authorized;
}
