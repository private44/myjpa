
package com.myjpa.service;

import com.myjpa.domain.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ServiceJPQL {
   
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DBOracle");
    private static final EntityManager EM = EMF.createEntityManager();
    
    public static void getAllBooks(){
        Query query = EM.createQuery("select e from Employee e");
        List<Employee> results = query.getResultList();
        
        for(Employee employee : results){
            System.out.println("First Name: " + employee.getFirstName());
        }
    }
}
