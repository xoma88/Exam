package com.example.exam.dataBase;

import java.util.List;

public interface ImageBaseHandler<T> {
    void create(T item);
    List<T> getAllImage();
}