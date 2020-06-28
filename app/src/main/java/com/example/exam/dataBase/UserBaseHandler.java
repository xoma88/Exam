package com.example.exam.dataBase;

import java.util.List;

public interface UserBaseHandler<T> {
    void create(T item);
    List<T> getAllUser(Integer[][] imageId);
}
