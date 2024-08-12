package com.systemOrderService.model.entities;

import com.systemOrderService.model.Exception.DomainException;

public class PhysicalPerson extends Person {
    private String cpf;
    private String rg;

    public PhysicalPerson(){
        super();
    }

    public PhysicalPerson(String name, String email, String address, String telephone, String zipCode, String cpf, String rg) throws DomainException {
        super(name, email, address, telephone, zipCode);
        if(cpf == null || cpf.length() != 11){
            throw new DomainException("Error cpf cannot be greater or less than 11 characters or.");
        }
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String formattedCpf(){
        return String.format("%s.%s.%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6,9),
                cpf.substring(9,11));
    }

    @Override
    public String showInfoPerson() {
        return super.showInfoPerson() + "\nCPF: " + formattedCpf() +"\n";
    }
}
