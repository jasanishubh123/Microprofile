/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productclientjwt.managedBean;

import com.mycompany.productclientjwt.client.productClient;
import com.mycompany.productresourcejwt.entity.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author shubham
 */
@Named(value = "productBean")
@SessionScoped
public class productBean implements Serializable {

    
    Product p;
    Collection<Product> colpol;
    
    @Inject @RestClient productClient pc;
    
    public productBean() {
        p= new Product();
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public Collection<Product> getColpol() {
        colpol =  pc.getProducts();
        return colpol;
    }

    public void setColpol(Collection<Product> colpol) {
        this.colpol = colpol;
    }
     
    public String addUpdateProduct(){
        if(p.getProductid()!=null){
            pc.addProduct(p);
        }else{
            pc.updateProduct(p);
        }
        
        return "admin.jsf?faces-redirect=true";
    }
    
    
    public void removeProduct(int id){
        
        pc.removeProduct(id);
        
    }
    
    public String editProduct(Product ps){
        p=ps;
        return "addProduct.jsf?faces-redirect=true";
    }
    
    
    
    
}
