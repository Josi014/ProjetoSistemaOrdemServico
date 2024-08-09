package com.systemOrderService.repositories.services;

import com.systemOrderService.model.entities.LegalPerson;
import com.systemOrderService.model.entities.PhysicalPerson;

import com.systemOrderService.entities.enums.Situation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderService {

    private int id;
    private Date date;
    private Situation situation;
    private String description;
    private String observation;
    private String equipmentType;
    private LegalPerson legalPerson;
    private PhysicalPerson physicalPerson;
    private SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public OrderService() {
    }

    public OrderService(int id, Date date, String situation, String description, String observation,String equipmentType) {
        this.id = id;
        this.date = date;
        this.situation = Situation.valueOf(situation);
        this.description = description;
        this.observation = observation;
        this.equipmentType = equipmentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public PhysicalPerson getPhysicalPerson() {
        return physicalPerson;
    }

    public void setPhysicalPerson(PhysicalPerson physicalPerson) {
        this.physicalPerson = physicalPerson;
    }

    public void updateSituation() {
        switch (situation) {
            case ABERTO:
                System.out.print("Order open");
                break;
            case FECHADO:
                System.out.print("Order closed");
                break;
        }
    }

    public  double total(double price, double amount) {
       return amount * price;
    }

}
