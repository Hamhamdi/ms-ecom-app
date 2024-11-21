package net.hamdi.customerservice.config;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

@RefreshScope //annotation that allows dynamically refreshing the configuration of a bean without restarting the application.
public class ConfigTestRest {

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;


    @GetMapping("/testconfig1")
    public Map<String,String> ConfigTest1(){
        return Map.of("p1",p1,"p2",p2);
    }


    @GetMapping("/testconfig2")
    public CustomerConfigParams ConfigTest2(){
        System.out.println(customerConfigParams);
        return customerConfigParams;
    }
}
