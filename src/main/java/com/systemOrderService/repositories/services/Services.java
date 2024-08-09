package com.systemOrderService.repositories.services;

import com.systemOrderService.entities.enums.Service;

public class Services {
    private String defect;
    private Service service;
    private Double price;


    public Services(String defect,String service) {
        this.defect = defect;
        this.service = Service.valueOf(service);
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


    public void newService() {
        switch (service) {
            case SUPORTE:
                price = 80.00;
                break;
            case LIMPEZA:
                price = 50.00;
                break;
            case FORMATAÇÃO:
                price =110.00;
                break;
            case BACKUP:
                price =55.00;
        }
    }

    public double getPrice() {
        return price;
    }


}
