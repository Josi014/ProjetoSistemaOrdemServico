package com.systemOrderService.repositories.services;
import com.systemOrderService.entities.enums.Service;
import com.systemOrderService.model.exception.DomainException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Services extends OrderService {
    private String defect;
    private Service service;
    private Double price;
    private Integer amountServices;
    private double soma = 0;
    List<Services> newListSer = new ArrayList<>();

    public Services() {
    }

    public Services(String situation, String description, String observation, String equipmentType, String defect, String service, Integer amountServices) throws DomainException {
        super(situation, description, observation, equipmentType);
        boolean validService = false;
        for (Service services : Service.values()) {
            if (services.name().equals(service)) {
                validService = true;
                break;
            }
        }
        if (!validService) {
            throw new DomainException("Choose a valid service.");
        }
        this.defect = defect;
        this.service = Service.valueOf(service);
        this.amountServices = amountServices;

    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void newService() throws DomainException {
        switch (service) {
            case SUPORTE:
                price = 80.00;
                break;
            case LIMPEZA:
                price = 50.00;
                break;
            case FORMATAÇÃO:
                price = 110.00;
                break;
            case BACKUP:
                price = 55.00;
            case TROCA:
                price = 100.00;
                break;
            case NENHUM:
                price = 0.0;
                break;
        }
    }

    public void showcaseServices() {
        for (Service services : Service.values()) {
            System.out.println(services);
        }
    }

    public double valueXQuantity() {
        return amountServices * price;
    }

    public void addListSoma(Services services) throws DomainException {
        services.newService();
        newListSer.add(services);
    }

    public double somaTotal() throws DomainException {
        for (Services service2 : newListSer) {
            soma += service2.valueXQuantity();
        }
        return soma;
    }

    @Override
    public String showInfo() throws DomainException {
        String txt = " ";
        DecimalFormat formatNum = new DecimalFormat("0.0#");

        txt += super.showInfo();
        txt += "\nService performed: " + service;
        txt += "\nNumber of times the service was performed: " + amountServices;
        txt += "\nTotal value R$: " + formatNum.format(somaTotal());

        return txt;
    }


}
