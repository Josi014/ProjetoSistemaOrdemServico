package com.systemOrderService.repositories.services;

import com.systemOrderService.entities.enums.Service;

public class Services {
    private String defect;
    private Service service;
    private Double value;


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

    public Double getValue() {
        return value;
    }

    public void newService() {
        switch (service) {
            case SUPORTE:
                value += 80.00;
                break;
            case LIMPEZA:
                value += 50.00;
                break;
            case FORMATAÇÃO:
                value+=110.00;
                break;
            case BACKUP:
                value+=55.00;
        }
    }
}
