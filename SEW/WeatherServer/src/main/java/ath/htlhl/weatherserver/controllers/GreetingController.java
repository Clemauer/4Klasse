package ath.htlhl.weatherserver.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weatherserver/greetings")

public class GreetingController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello(
            @RequestParam(defaultValue = "World")String name){
        return String.format("Hello, %s!", name);
    }

}
