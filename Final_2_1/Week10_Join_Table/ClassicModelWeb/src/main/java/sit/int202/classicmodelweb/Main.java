package sit.int202.classicmodelweb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.repositories.OfficeRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("classic-model");
//        EntityManager em = emf.createEntityManager();
//        Office office = em.find(Office.class, "4");
        OfficeRepository officeRepository = new OfficeRepository();
        Office office = officeRepository.find("1");
        if (office.getCity().equalsIgnoreCase("bangkok")) {
            office.setCity("Vientiane");
        } else {
            office.setCity("Bangkok");
        }
//        officeRepository.update(office); //call saveoffice
//        saveOffice(officeRepository);
          deleteOffice(officeRepository);

        officeRepository.update(office);

        System.out.println(office);
        System.out.println("-------------------");
        office.getEmployeeList().forEach(e -> {
            System.out.printf("%10d %-10s %-12s %s\n",
                    e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
        });
//        em.close();
    }

//    private static void saveOffice(OfficeRepository officeRepository) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter new office id: ");
//        String officeCode = sc.next();
//        System.out.print("Enter new office city: ");
//
//        Office newOffice = new Office();
//        newOffice.setId(officeCode);
//        newOffice.setCity("Songkhla");
//        newOffice.setCountry("TH");
//        newOffice.setAddressLine1("126 Pracha-utit");
//        newOffice.setPhone("012-345-6789");
//        newOffice.setPostalCode("10140");
//        newOffice.setTerritory("NA");
//        if (!officeRepository.save(newOffice)) {
//            System.out.println("Error: Can't insert new office");
//        }
//    }

    private static void deleteOffice(OfficeRepository officeRepository) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter office id to delete: ");
        String officeCode = sc.next();
        if(! officeRepository.delete(officeCode)) {
            System.out.println("Error: Can't insert new office");
        } else {
            System.out.println("Office id "+ officeCode + " has been deleted !!");
        }
    }
}
