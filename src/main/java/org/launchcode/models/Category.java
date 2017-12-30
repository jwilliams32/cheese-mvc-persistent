package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

  @Id
  @GeneratedValue
  private int id;

  @NotNull
  @Size(min=3, max=15)
  private String name;
//  each category will have many cheeses but only one cheese can have only one category
//  Join tells hibernate to use category_id column of the cheese table
  @OneToMany
  @JoinColumn(name = "category_id")
  private List<Cheese> cheeses = new ArrayList<>();
//  Default constructor for hibernate



//  Constructor that accepts a parameter to set name
    public Category(String name){
      this.name = name;
  }

    public Category(){ }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }
}
