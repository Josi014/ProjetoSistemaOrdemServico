package com.systemOrderService.model.entities;

public class PhysicalPerson extends Person {
    private String cpf;
    private String rg;


    public PhysicalPerson(){
        super();
    }

    public PhysicalPerson(String name, String email, String adress, String telephone, String zipCode, String cpf, String rg) {
        super(name, email, adress, telephone, zipCode);
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

    public void formattedCpf(String cpf) {
        String formattedCpf = String.format("%s.%s.%s/%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6,9),
                cpf.substring(9,11));
        System.out.print(formattedCpf);
    }
}
