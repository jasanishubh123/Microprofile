/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productresources.service;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author shubham
 */
@Named
@SessionScoped
public class RowToken implements  Serializable {
    
    private static String rtoken;

    public static String getRtoken() {
        return rtoken;
    }

    public static void setRtoken(String rtoken) {
        RowToken.rtoken = rtoken;
    }
    
    
    
}
