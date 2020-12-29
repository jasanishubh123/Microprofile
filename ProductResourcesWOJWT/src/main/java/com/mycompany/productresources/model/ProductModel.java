/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productresources.model;

import com.mycompany.stockresources.entity.Product;
import java.util.Collection;
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
public class ProductModel {

    EntityManager em;
    Collection<Product> products;
    Collection<Product> availableProducts;

    public ProductModel() {

        em = Persistence.createEntityManagerFactory("productPU").createEntityManager();

    }

    public Collection<Product> getProducts() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Product> getAvailableProducts(Collection<Integer> ids) {
        
        String pids =  convertIntCollectionToString(ids);
        availableProducts = em.createQuery("SELECT p from Product p WHERE p.productid IN ("+pids+")").getResultList();
        return availableProducts;
    }

    public void setAvailableProducts(Collection<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    private String convertIntCollectionToString(Collection<Integer> ids) {
        String intString = "";
        for (Integer i : ids) {
            intString += i.toString() + ",";
        }
        return intString.substring(0, intString.length() - 1);
    }
    
    public void addProducts(Product p){
        
        try {
             em.getTransaction().begin();
             
             if(p.getProductid()>0 ||p.getProductid()!=0){
                 em.merge(p);
             }else{
                 em.persist(p);
             }
             
             
             em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
       
        
    }
    
    
    public Collection<Product> getAllProduct(){
        return em.createNamedQuery("Product.findAll").getResultList();
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

}
