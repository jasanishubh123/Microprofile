/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author shubham
 */
@Stateless
@DeclareRoles({"Admin"})
public class TrialEjb implements TrialEjbLocal {

    @Override
    @RolesAllowed("Admin")
    public String sayHelloToAdmin() {
        return "Hello Admin";
    }

}
