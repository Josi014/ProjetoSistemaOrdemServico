package com.systemOrderService.model.entities;

import java.util.ArrayList;
import java.util.List;

abstract public class Person {
    private String name;
    private String email;
    private String adress;
    private String telephone;
    private String zipCode;
    private List<Person> listPerson = new ArrayList<>();


    public Person() {
    }

    public Person(String name, String email, String adress, String telephone, String zipCode) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.telephone = telephone;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void formattedNumber(String numberPhone) {
        String formattedNumber = String.format("(%s) %s-%s",
                numberPhone.substring(0, 2),
                numberPhone.substring(2, 7),
                numberPhone.substring(7));
        System.out.print(formattedNumber);
    }


    public void addPerson(Person person){
        listPerson.add(person);
        for(Person p :listPerson){
            System.out.print(p);
        }
    }

    public void removePerson(Person person){
        listPerson.remove(person);
        for(Person p :listPerson){
            System.out.print(p);
        }
    }

    @Override
    public String toString() {
        return "Person name='" + name;
    }


}
