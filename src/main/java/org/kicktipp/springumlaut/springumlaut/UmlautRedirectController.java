package org.kicktipp.springumlaut.springumlaut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class UmlautRedirectController {

    @GetMapping("/hallo")
    public String hallo() {
        return "redirect:/hallöchen";
    }

    @ResponseBody
    @GetMapping("/hallöchen")
    public String helloWithUmlaut() {
        return "Hallöchen";
    }

    // ohne Umlaute

    @GetMapping("/hello")
    public String hello() {
        return "redirect:/hi";
    }

    @ResponseBody
    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

    // solutions by Toni
    // https://stackoverflow.com/a/78022592/351758
    @GetMapping("/redirectattributes")
    public String redirectattributes(RedirectAttributes attributes) {
        attributes.addAttribute("var", "hallöchen");
        return "redirect:/{var}";
    }

    @GetMapping("/encoding")
    public String encoding() throws UnsupportedEncodingException {
        return "redirect:/" + URLEncoder.encode("hallöchen", StandardCharsets.UTF_8);
    }
}
