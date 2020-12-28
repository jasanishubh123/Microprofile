/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockresources.model;

import com.mycompany.stockresources.entity.Stock;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author shubham
 */

@Named
@ApplicationScoped
public class stockModel {
    
    EntityManager em;
    
    Collection<Integer> nonZeroProductsIds;

    public stockModel() {
            
        em = Persistence.createEntityManagerFactory("stockPU").createEntityManager();
    
    }

//    @RolesAllowed("Admin")
    public Collection<Integer> getNonZeroProductsIds() {
        
        nonZeroProductsIds = new ArrayList<>();
        Collection<Stock> stocks = em.createQuery("SELECT s from Stock s  WHERE s.quantity > 0").getResultList();
        
        for(Stock s:stocks){
              nonZeroProductsIds.add(s.getProductid().getProductid());
        }
        
        return nonZeroProductsIds;
    }

    public void setNonZeroProductsIds(Collection<Integer> nonZeroProductsIds) {
        this.nonZeroProductsIds = nonZeroProductsIds;
    }
    
    
    
    
    
    
    
}
