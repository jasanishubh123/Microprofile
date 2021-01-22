/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerservice.model;

import com.mycompany.customerservice.config.Customer;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author shubham
 */

@ApplicationScoped
@Named
public class CustomerModel {
    
    EntityManager em;

    public CustomerModel() {
        em = Persistence.createEntityManagerFactory("spu").createEntityManager();
    }
    
    
   public  Collection<Customer> getCustomersWithRating(String condition, int
rating){
       
//       System.out.println("Condition - "+condition +" rating "+rating);
      
        Collection<Customer> custs;
         custs= new ArrayList<>();
        if(condition.equals("lessthan equal")){
           
            custs = em.createQuery("SELECT c FROM Customer c WHERE c.rating <= :rating").setParameter("rating", rating).getResultList();
        }else if(condition.equals("greaterthan equal")){
             custs = em.createQuery("SELECT c FROM Customer c WHERE c.rating >= :rating").setParameter("rating", rating).getResultList();
        }else if(condition.equals("lessthan")){
             custs = em.createQuery("SELECT c FROM Customer c WHERE c.rating < :rating").setParameter("rating", rating).getResultList();
        }else if(condition.equals("greaterthan")){
             custs = em.createQuery("SELECT c FROM Customer c WHERE c.rating > :rating").setParameter("rating", rating).getResultList();
        }else if(condition.equals("equal")){
             custs = em.createQuery("SELECT c FROM Customer c WHERE c.rating = :rating").setParameter("rating", rating).getResultList();
        }
        
        for (Customer cust : custs) {
            System.out.println("customer "+cust.getName());
       }
        
        return custs;
    }
    
    
    
}
