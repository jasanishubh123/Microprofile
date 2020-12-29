/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopclient.managedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.auth.message.AuthStatus;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
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
public class LoginBean {

    String Username, Password;
    @Inject SecurityContext sc;
    AuthenticationStatus status;
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String login() {
        try {
            message = "";
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            Credential credential = new UsernamePasswordCredential(Username, new Password(Password));
            status = sc.authenticate(req, res, withParams().credential(credential));
            if (status.equals(AuthenticationStatus.SUCCESS)) {
                if (sc.isCallerInRole("Supervisor")) {
                    return "user/user.jsf?faces-redirect=true";
                } else if (sc.isCallerInRole("Admin")) {
                    return "admin/admin.jsf?faces-redirect=true";
                }
            } else if (status.equals(AuthenticationStatus.SEND_FAILURE)) {
                setMessage("Either Login or Password is wrong");
                System.out.println(message);
                return "index.jsf";
            }
        }catch (Exception e) {
            setMessage("Either Login or Password is wrong");
            System.out.println(e);
            return "index.jsf";
        }
        return "index.jsf";
    }

}
