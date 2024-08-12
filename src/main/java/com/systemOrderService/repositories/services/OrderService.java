package com.systemOrderService.repositories.services;
import com.systemOrderService.entities.enums.Situation;
import com.systemOrderService.model.exception.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class OrderService {

    private Situation situation;
    private String description;
    private String observation;
    private String equipmentType;
    private final SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public OrderService() {
    }

    public OrderService(String situation, String description, String observation, String equipmentType) {
        this.situation = Situation.valueOf(situation);
        this.description = description;
        this.observation = observation;
        this.equipmentType = equipmentType;
    }


    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public String updateSituation() {
        String situationOrder = "";
        switch (situation) {
            case ABERTO:
                Date date = new Date();
                situationOrder = "Order open " + mascaraData.format(date);
                break;
            case FECHADO:
                Date closingDate = new Date();
                situationOrder = "Order closed " + mascaraData.format(closingDate);
                break;
        }
        return situationOrder;
    }

    public String showInfo() throws DomainException {
        int id = 0;
        System.out.print("\nID: " + id);
        String txt = " ";
        txt += "\nService order status: " + updateSituation() + "\n";
        txt += "\nDescription: " + description;
        txt += "\nObservation: " + observation;
        txt += "\nEquipment type: " + equipmentType;

        return txt;
    }
}
