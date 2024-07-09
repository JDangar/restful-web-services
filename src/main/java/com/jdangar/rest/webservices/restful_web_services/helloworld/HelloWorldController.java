package com.jdangar.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello World");
    }

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name){
        return new HelloWorld(String.format(Locale.US, "Hello World, %s", name));
    }
}
