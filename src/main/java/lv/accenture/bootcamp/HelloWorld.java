package lv.accenture.bootcamp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;


@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }


}
