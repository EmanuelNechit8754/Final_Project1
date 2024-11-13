package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class WelcomeController {
    @GetMapping("/add-component")
    public String showAddComponentPage(){
        return "add-component";
    }
    @GetMapping("/welcome")
    public String showWelcomePage(){
        return "welcome";
    }
}
