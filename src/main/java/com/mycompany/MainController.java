package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // this is main controller  of the application, and we need to use the analyctics annotation controller
public class MainController {

@GetMapping("") // we need to use the Getmapping annotion
    public String showHomePage(){
    System.out.println("main controller");
    return "index";
}

}
