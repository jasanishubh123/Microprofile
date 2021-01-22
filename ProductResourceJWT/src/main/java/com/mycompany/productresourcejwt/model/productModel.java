/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productresourcejwt.model;

import com.mycompany.productresourcejwt.entity.Product;
import com.mycompany.productresourcejwt.entity.Product_;
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
public class productModel {
    
    EntityManager em;

    public productModel() {
        em= Persistence.createEntityManagerFactory("ppu").createEntityManager();
    }
    
    
    public void addUpdateProduct(Product p){
        
        try {
            em.getTransaction().begin();
            
            if(p.getProductid() != null){
                em.merge(p);
            }else{
                em.persist(p);
            }
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
    }
    
    
    public void removeProduct(int id){
        
        try {
            
            em.getTransaction().begin();
            
            Product p = em.find(Product.class, id);
            em.remove(p);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
    }
    
    public Collection<Product> getProduts(){
        
        return em.createNamedQuery("Product.findAll").getResultList();
        
    }
    
    
}
