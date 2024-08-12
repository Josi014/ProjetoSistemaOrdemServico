package com.systemOrderService.model.entities;

import com.systemOrderService.model.exception.DomainException;

abstract public class Person {
    private String name;
    private String email;
    private String address;
    private String telephone;
    private String zipCode;

    public Person() {
    }

    public Person(String name, String email, String address, String telephone, String zipCode) throws DomainException {
        if(telephone == null || telephone.length() != 11){
            throw new DomainException("Telephone number cannot be longer or shorter than 11 characters.");
        }
        this.name = name;
        this.email = email;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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


    public String formattedNumber(){
        return String.format("(%s) %s-%s",
                telephone.substring(0, 2),
                telephone.substring(2, 7),
                telephone.substring(7));
    }


    public String showInfoPerson(){
        String txt = " ";
        txt = "\nPerson name=" + name;
        txt += "\n";
        txt += "Email address: " + email;
        txt += "\nPhone number: " + formattedNumber();
        return txt;
    }

}
