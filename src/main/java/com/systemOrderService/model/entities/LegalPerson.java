package com.systemOrderService.model.entities;

import com.systemOrderService.model.exception.DomainException;

public class LegalPerson extends Person{
    private String reason;
    private String cnpj;
    private String stateRegistration;

    public LegalPerson(){
        super();
    }

    public LegalPerson(String name, String email, String address, String telephone, String zipCode, String reason, String cnpj, String stateRegistration) throws DomainException {
        super(name, email, address, telephone, zipCode);
        if(cnpj == null || cnpj.length() != 14){
            throw new DomainException("Error cnpj cannot be greater or less than 14 characters or.");
        }
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String formattedCnpj(){
        return String.format("%s.%s.%s/%s-%s",
                cnpj.substring(0, 2),
                cnpj.substring(2, 5),
                cnpj.substring(5,8),
                cnpj.substring(8,12),
                cnpj.substring(12,14));
    }


    @Override
    public String showInfoPerson(){
        return super.showInfoPerson() + "\nCNPJ: " + formattedCnpj()+"\n";
    }
}
