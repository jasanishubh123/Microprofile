/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopclient.managedBean;

import com.mycompany.shopclient.client.ProductClient;
import com.mycompany.stockresources.entity.Product;
import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


/**
 *
 * @author shubham
 */
@Named(value = "productBean")
@SessionScoped
public class productBean implements  Serializable{

    Product p;
    @Inject ProductClient pc;
    Collection<Product> colp;
    /**
     * Creates a new instance of productBean
     */
    public productBean() {
        p= new Product();
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }
    
    
    public String addProduct(){
        System.out.println(p.getProductname()+" "+p.getDescription()+" "+p.getPrice());
        pc.addProduct(p);
        return "displayProduct.jsf?faces-redirect=true";
    }

    public Collection<Product> getColp() {
        colp=pc.getAllProducts();
        return colp;
    }

    public void setColp(Collection<Product> colp) {
        this.colp = colp;
    }
    
    
    public String EditProduct(Product pro){
        p=pro;
       return "addProduct.jsf?faces-redirect=true";
    }
    
    
     public String RemoveProduct(int pro){
        pc.removeProduct(pro);
       return "displayProduct.jsf?faces-redirect=true";
    }
    
    
    
}
