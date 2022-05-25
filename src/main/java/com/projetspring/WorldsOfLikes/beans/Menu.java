package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String menu;
    private double price;

    //constructeur




    public Menu( String menu, double price) {

        this.menu = menu;
        this.price = price;
    }

    public Menu(){}

    //get et set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //to String

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menu='" + menu + '\'' +
                ", price=" + price +
                '}';
    }
}
