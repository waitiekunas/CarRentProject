package com.vcs.controlers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class Index {

    @RequestMapping("/")
    public String Hello() {


        return "Hello! For clients go to clients, for admins, go to admin";
    }

}
