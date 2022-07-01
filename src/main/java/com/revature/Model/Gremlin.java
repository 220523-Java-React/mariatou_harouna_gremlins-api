package com.revature.Model;

import java.io.Serializable;
import java.util.Objects;

public class Gremlin implements Serializable {

    /*Variables declaration
        Declaring variables which are attributes for each gremlin objects with their datatype
    */
    private Integer id;
    private String name;
    private Integer age;
    private String color;
    private Boolean isEvil;

    // No args constructor
    public Gremlin(){

    }

    // Constructor
    public Gremlin(Integer id, String name, Integer age, String color, Boolean isEvil){
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.isEvil = isEvil;
    }

    /*Variables are declared privates, so we need public getters and setters to expose the variables
     outside of the class
     Getters and setters for all variables
    */

    public Integer getId() {
        return id;
    }

    public Gremlin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Gremlin setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Gremlin setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Gremlin setColor(String color) {
        this.color = color;
        return this;
    }

    public Boolean getEvil() {
        return isEvil;
    }

    public Gremlin setEvil(Boolean evil) {
        isEvil = evil;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gremlin gremlin = (Gremlin) o;
        return Objects.equals(id, gremlin.id) && Objects.equals(name, gremlin.name) && Objects.equals(age, gremlin.age) && Objects.equals(color, gremlin.color) && Objects.equals(isEvil, gremlin.isEvil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, color, isEvil);
    }

    @Override
    public String toString() {
        return "Gremlin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", isEvil=" + isEvil +
                '}';
    }
}
