package com.example.exam.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    Integer id;
    String name;
    String author;
    Integer authorId;
    String description;
    String url;
}
