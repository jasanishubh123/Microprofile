/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productclientjwt.managedBean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author shubham
 */
@Named(value = "loginBean")
@RequestScoped
public class loginBean {

    AuthenticationStatus status;
    @Inject SecurityContext sc;
    String username,password,message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public loginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        
        try {
            
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            Credential credential = new UsernamePasswordCredential(username,new Password(password));
            
            status = sc.authenticate(request, response, AuthenticationParameters.withParams().credential(credential));
            
            String login_status =(String)request.getSession().getAttribute("status");
            List groups =(List)request.getSession().getAttribute("groups");
            if(login_status.equals("Login_Success")){
                
                if(groups.contains("Admin")){
                    return "admin/admin.jsf?faces-redirect=true";
                }else if(groups.contains("Supervisor")){
                    return "user/user.jsf?faces-redirect=true";
                }
                
            }else{
                setMessage("username password wrong");
            }
            
            
            
        } catch (Exception e) {
            setMessage("Username password may be wrong");
        }
        
        
        return null;
        
    }
    
}
