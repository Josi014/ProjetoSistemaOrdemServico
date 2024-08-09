package com.systemOrderService.model.entities;

import com.systemOrderService.repositories.services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class LegalPerson extends Person{
    private String reason;
    private int cnpj;
    private String stateRegistration;
    private List<OrderService> listNewOrder = new ArrayList<>();

    public LegalPerson(){
        super();
    }

    public LegalPerson(String name, String email, String adress, String telephone, String zipCode, String reason, int cnpj, String stateRegistration) {
        super(name, email, adress, telephone, zipCode);
        this.reason = reason;
        this.cnpj = cnpj;
        this.stateRegistration = stateRegistration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public List<OrderService> getListNewOrder() {
        return listNewOrder;
    }

    public void formattedCnpj(String cnpj) {
        String formattedCnpj = String.format("%s.%s.%s/%s-%s",
                cnpj.substring(0, 2),
                cnpj.substring(2, 5),
                cnpj.substring(5,8),
                cnpj.substring(8,12),
                cnpj.substring(12,14));
        System.out.print(formattedCnpj);
    }

    public void addOrderService(OrderService order) {
        listNewOrder.add(order);
        order.setLegalPerson(this);
    }

    public void removeOrderService(OrderService order) {
        listNewOrder.remove(order);
        order.setLegalPerson(null);
    }
}