package bbackjk.test.caat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping(value = "/hello")
    String hello() {
        return "Hello";
    }
}
