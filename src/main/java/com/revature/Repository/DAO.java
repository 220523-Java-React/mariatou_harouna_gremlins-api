package com.revature.Repository;


import java.util.List;

public interface DAO<T> {

    /*
    Data Access Object leverages generics, so it must perform operations on objects of type T
    and contains only abstract methods
     */
    Boolean create(T t); // method to create a generic type T object

    List<T> getAll(); // method to get all objects of generic type T List


}
