
package com.myjpa.service;

import com.myjpa.domain.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ServiceJPQL {
   
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DBOracle");
    private static final EntityManager EM = EMF.createEntityManager();
    
    public static void addBook(String firstName, String lastName, Date birthDate, String city, String gender, boolean active){
 
        Employee employee = new Employee(); 
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setBirthDate(birthDate);
        employee.setCity(city);
        employee.setGender(gender);
        employee.setActive(active);
        
        EM.getTransaction().begin();
        EM.persist(employee);
        EM.getTransaction().commit();
    }
    
    public static void getAllEmployees(){
        Query query = EM.createQuery("select e from Employee e");
        List<Employee> results = query.getResultList();
        
        for(Employee employee : results){
            System.out.println("First Name: " + employee.getFirstName());
        }
    }
    
    public static void getTotalEmployees(){
        Query query = EM.createQuery("select count(e) from Employee e");
        Long result = (Long) query.getSingleResult();
        System.out.println("Total employee: " + result); 
    }
}
