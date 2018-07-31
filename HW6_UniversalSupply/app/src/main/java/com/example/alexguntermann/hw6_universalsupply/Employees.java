package com.example.alexguntermann.hw6_universalsupply;

/**
 * Created by alexguntermann on 4/25/18.
 */

public class Employees {

    private String firstName, lastName, gender, diet, favorite_food1, favorite_food2, favorite_color;
    private int age, salary;


public Employees(){
        firstName = "";
        lastName = "";
        gender = "";
        diet = "";
        favorite_food1 = "";
        favorite_food2 = "";
        favorite_color = "";
        age = 0;
        salary = 0;
    }

    // String fst,String scnd,String col,String diet,String food,String food2,String gndr,int ag,int sal



    public Employees(String firstName, String lastName, String gender, String diet,
                     String favorite_food1, String favorite_food2, String favorite_color, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.diet = diet;
        this.favorite_food1 = favorite_food1;
        this.favorite_food2 = favorite_food2;
        this.favorite_color = favorite_color;
        this.age = age;
        this.salary = salary;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getFavorite_food1() {
        return favorite_food1;
    }

    public void setFavorite_food1(String favorite_food1) {
        this.favorite_food1 = favorite_food1;
    }

    public String getFavorite_food2() {
        return favorite_food2;
    }

    public void setFavorite_food2(String favorite_food2) {
        this.favorite_food2 = favorite_food2;
    }

    public String getFavorite_color() {
        return favorite_color;
    }

    public void setFavorite_color(String favorite_color) {
        this.favorite_color = favorite_color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getFullName(){
    return this.firstName + " " + this.lastName;
    }


}



