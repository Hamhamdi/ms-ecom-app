package net.hamdi.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types= Customer.class)
public interface CustomerProjection {
    // localhost:8081/cutomers/1?projection=all : generate the response with only (name , email)
    // --> Spring data rest
    String getName();
    String getEmail();
}
