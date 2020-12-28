/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopclient.project;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author shubham
 */

@DatabaseIdentityStoreDefinition(
        callerQuery = "select password from users where username = ?",
        groupsQuery = "select GROUPNAME from groups where username = ?",
        dataSourceLookup = "jdbc/stockapp",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)
@ApplicationScoped
public class ProjectConfig {
    
}
