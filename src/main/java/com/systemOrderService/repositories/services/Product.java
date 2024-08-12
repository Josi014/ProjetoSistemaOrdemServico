package com.systemOrderService.repositories.services;

import com.systemOrderService.entities.enums.Products;
import com.systemOrderService.entities.enums.Service;
import com.systemOrderService.model.Exception.DomainException;

import java.text.DecimalFormat;

public class Product extends Services {
    private String nicknameProduct;
    private Products product;
    private Double price;
    private Integer amount;
    private double sum = 0;

    public Product() {
        super();
    }

    public Product(String situation, String description, String observation, String equipmentType, String defect, String service, Integer amountServices, String nicknameProduct, String product, Integer amount) throws DomainException {
        super(situation, description, observation, equipmentType, defect, service, amountServices);
        boolean validProduct = false;
        for (Products products : Products.values()) {
            if (products.name().equals(products)) {
                validProduct = true;
                break;
            }
        }
        if (!validProduct) {
            throw new DomainException("Choose a valid product.");
        }
        this.nicknameProduct = nicknameProduct;
        this.product = Products.valueOf(product);
        this.amount = amount;
    }

    public String getNicknameProduct() {
        return nicknameProduct;
    }

    public void setNicknameProduct(String nicknameProduct) {
        this.nicknameProduct = nicknameProduct;
    }

    public Products getProducts() {
        return product;
    }

    public void setProducts(Products products) {
        this.product = products;
    }

    public void newProduct(){
        switch (product) {
            case SSD:
                price = 230.00;
                break;
            case MEMÓRIA:
                price = 150.00;
                break;
            case IMPRESSORA:
                price = 500.00;
                break;
            case TECLADO:
                price = 100.00;
                break;
            case MOUSE:
                price = 55.00;
                break;
            case SWITCH5P:
                price = 155.00;
                break;
            case SWITCH8P:
                price = 200.00;
                break;
            case ROTEADOR:
                price = 250.00;
                break;
            case TELA:
                price = 200.0;
                break;
        }
    }

    @Override
    public double valueXQuantity() {
        return price * amount;
    }

    @Override
    public double somaTotal() throws DomainException {
        newProduct();
        newService();
        sum += super.valueXQuantity() + valueXQuantity();
        return sum;
    }

    @Override
    public void newService() throws DomainException {
        super.newService();
    }

    public void showcaseProducts(){
        for (Products product : Products.values()) {
            System.out.println(product);
        }
    }

    @Override
    public final String showInfo() throws DomainException {
        DecimalFormat formatoNum = new DecimalFormat("0.0#");
        String txt = " ";
        txt =  "\nService: " + getService();
        txt += "\nProduct name: " + nicknameProduct;
        txt += "\nProduct: " + product;
        txt += "\nAmount: " + amount;
        txt += "\nTotal value R$: ";
        txt += formatoNum.format(somaTotal());

        return txt;
    }

}
