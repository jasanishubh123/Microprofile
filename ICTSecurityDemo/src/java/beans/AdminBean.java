/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.adminClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author shubham
 */
@Named(value = "adminBean")
@RequestScoped
public class AdminBean {

    /**
     * Creates a new instance of AdminBean
     */
    
    adminClient ac;
    
    public AdminBean() {
        
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        token = (String)request.getSession().getAttribute("token");
        System.err.println("TOKEN = "+token);
    }
    
    String hello,token;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    
    
    public String getHelloFromRest(){
        
        ac= new adminClient(token);
        return ac.getHello();
        
        
    }
    
}
