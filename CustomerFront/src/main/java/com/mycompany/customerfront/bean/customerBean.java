/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerfront.bean;

import com.mycompany.customerfront.client.CustomerClient;
import com.mycompany.customerfront.config.Customer;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author shubham
 */
@Named(value = "customerBean")
@SessionScoped
public class customerBean implements  Serializable{

    
    String condition;
    int rating;
    Collection<Customer> colcust;
    @Inject @RestClient CustomerClient cc;
    
    /**
     * Creates a new instance of customerBean
     */
    public customerBean() {
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Collection<Customer> getColcust() {
        return colcust;
    }

    public void setColcust(Collection<Customer> colcust) {
        this.colcust = colcust;
    }
    
    
    public Collection<Customer> search(){
        
        System.out.println("Condition - "+condition +" rating "+rating);
        colcust =  cc.get(condition, rating);
        return colcust;
    }
    
    
    
    
}
