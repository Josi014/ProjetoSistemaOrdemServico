package org.example;

import com.systemOrderService.entities.enums.Situation;
import com.systemOrderService.model.exception.DomainException;
import com.systemOrderService.model.entities.LegalPerson;
import com.systemOrderService.model.entities.PhysicalPerson;
import com.systemOrderService.repositories.services.Product;
import com.systemOrderService.repositories.services.Services;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Services services = new Services();
        LegalPerson legalPerson = new LegalPerson();
        PhysicalPerson physicalPerson = new PhysicalPerson();
        try{
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your email: ");
            String email = sc.nextLine();
            System.out.print("Enter your address: ");
            String address = sc.nextLine();
            System.out.print("Enter your phone number: ");
            String telephone = sc.nextLine();
            System.out.print("Enter your zip code: ");
            String zipCode = sc.nextLine();
            System.out.print("Are you a legal or physical person?");
            String opcaoPerson = sc.nextLine().toUpperCase();
            if (opcaoPerson.equals("PHYSICAL")) {
                System.out.print("Enter your CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Enter your General Registry(RG): ");
                String rg = sc.nextLine();
                physicalPerson = new PhysicalPerson(name, email, address, telephone, zipCode, cpf, rg);
            } else {
                System.out.print("Enter your company name: ");
                String reason = sc.nextLine();
                System.out.print("Enter your CNPJ: ");
                String cnpj = sc.nextLine();
                System.out.print("Enter your state registration: ");
                String stateRegistration = sc.nextLine();
                legalPerson = new LegalPerson(name, email, address, telephone, zipCode, reason, cnpj, stateRegistration);
            }
            System.out.print("/////Service order started/////");
            System.out.println("Current order status: OPEN");
            System.out.println("Description: ");
            String description = sc.nextLine();
            System.out.println("Observation: ");
            String observation = sc.nextLine();
            System.out.println("equipment Type: ");
            String equipmentType = sc.nextLine();

            System.out.print("Choose one of the options below: \n1.Add new service\n2.Add new product and service. \n");
            int op = sc.nextInt();
            sc.nextLine();
            System.out.print("Describe the defect: ");
            String defect = sc.nextLine();
            System.out.print("Available services: \n");
            services.showcaseServices();
            System.out.print("Inform the service: ");
            String ser = sc.nextLine();
            String service = ser.toUpperCase();
            System.out.print("Amount? ");
            int amountServices = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    services = new Services("ABERTO", description, observation, equipmentType, defect, service, amountServices);
                    services.addListSoma(services);
                    validatePerson(opcaoPerson, physicalPerson, legalPerson);
                    System.out.print(services.showInfo());
                    break;
                case 2:
                    Product products = new Product();
                    System.out.print("Products in stock: \n");
                    products.showcaseProducts();
                    System.out.print("Enter the Product's nickname: ");
                    String nicknameProduct = sc.nextLine();
                    System.out.print("Enter the product by its stock ID: ");
                    String prod = sc.nextLine();
                    String product = prod.toUpperCase();
                    System.out.print("Amount? ");
                    int amount = sc.nextInt();
                    products = new Product("ABERTO", description, observation, equipmentType, defect, service, amountServices, nicknameProduct, product, amount);
                    validatePerson(opcaoPerson, physicalPerson, legalPerson);
                    System.out.print(products.showInfo());
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }

            System.out.print("\n" +"Do you want to close the service order? Y/N   ");
            char opcao = sc.next().charAt(0);
            if(opcao=='Y' || opcao=='y'){
                services.setSituation(Situation.FECHADO);
                System.out.println(services.updateSituation());
            }else{
                System.exit(0);
            }

        }catch (DomainException e){
            System.out.println("Error in order: " + e.getMessage());

        }

    }

    public static void validatePerson(String opcaoPerson, PhysicalPerson physicalPerson, LegalPerson legalPerson) throws DomainException {
        if(opcaoPerson.equals("PHYSICAL")){
            if(physicalPerson != null){
                System.out.print(physicalPerson.showInfoPerson());
            }
        }else{
            if(legalPerson!=null){
                System.out.print(legalPerson.showInfoPerson());
            }
        }
    }
}