package com.mycompany.testjwtservice.config;
import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

@SuppressWarnings({"EmptyClass", "SuppressionAnnotation"})
@ApplicationPath("rest")
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"Admin","User"})
public class BootStrap extends javax.ws.rs.core.Application {
}
