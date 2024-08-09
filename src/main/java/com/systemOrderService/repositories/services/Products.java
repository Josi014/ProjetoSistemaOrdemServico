package com.systemOrderService.repositories.services;

import com.systemOrderService.entities.enums.Group;
import com.systemOrderService.model.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private String nicknameProduct;
    private Group group;
    private List<Products> listProducts = new ArrayList<>();

    public Products(String nicknameProduct, String group) {
        this.nicknameProduct = nicknameProduct;
        this.group = Group.valueOf(group);
    }

    public String getNicknameProduct() {
        return nicknameProduct;
    }

    public void setNicknameProduct(String nicknameProduct) {
        this.nicknameProduct = nicknameProduct;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addPerson(Products products){
        listProducts.add(products);
        for(Products prod :listProducts){
            System.out.print(prod);
        }
    }

    public void removePerson(Products products){
        listProducts.remove(products);
        for(Products prod :listProducts){
            System.out.print(prod);
        }
    }



}
