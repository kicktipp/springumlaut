package org.kicktipp.springumlaut.springumlaut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UmlautRedirectController {

    @GetMapping("/hallo/")
    public String hallo() {
        return "redirect:/hallöchen";
    }

    @ResponseBody
    @GetMapping("/hallöchen")
    public String helloWithUmlaut() {
        // not reached so missing template does not matter
        return "Hallöchen";
    }


    @GetMapping("/hello/")
    public String hello() {
        return "redirect:/hi/";
    }

    @ResponseBody
    @GetMapping("/hi/")
    public String hi() {
        // not reached so missing template does not matter
        return "Hi";
    }
}
