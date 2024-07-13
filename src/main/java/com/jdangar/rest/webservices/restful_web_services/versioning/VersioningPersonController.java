package com.jdangar.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //URL Versioning
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("Jignesh Dangar");
    }

    //URL Versioning
    @GetMapping("/v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("Jignesh", "Dangar"));
    }

    //Request Parameter Versioning
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1RequestParameter(){
        return new PersonV1("Jignesh Dangar");
    }

    //Request Parameter Versioning
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2RequestParameter(){
        return new PersonV2(new Name("Jignesh", "Dangar"));
    }

    //Request Header Versioning
    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1RequestHeader(){
        return new PersonV1("Jignesh Dangar");
    }

    //Request Header Versioning
    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2RequestHeader(){
        return new PersonV2(new Name("Jignesh", "Dangar"));
    }

    //Media type Versioning (a.k.a "Content negotiation or "Accept header"
    @GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1AcceptHeader(){
        return new PersonV1("Jignesh Dangar");
    }

    //Media type Versioning (a.k.a "Content negotiation or "Accept header"
    @GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2AcceptHeader(){
        return new PersonV2(new Name("Jignesh", "Dangar"));
    }
}
