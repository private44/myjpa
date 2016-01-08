package com.myjpa.service.criteria;

import com.myjpa.domain.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ServiceCriteria {
    
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DBOracle");
    private static final EntityManager EM = EMF.createEntityManager();
    
    public static void getAllBooks(){
        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> emp = cq.from(Employee.class);
        cq.select(emp).where(cb.equal(emp.get("city"), "Chisinau"));
        
        TypedQuery<Employee> query = EM.createQuery(cq);
        query.getResultList();
    }
}
