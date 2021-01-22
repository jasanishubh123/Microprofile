/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productclientjwt.managedBean;

import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author shubham
 */
@Named
@SessionScoped
public class MyToken implements Serializable {

  private static String rtoken;

    public static String getRtoken() {
        return rtoken;
    }

    public static void setRtoken(String rtoken) {
        MyToken.rtoken = rtoken;
    }
    
    
    
}
