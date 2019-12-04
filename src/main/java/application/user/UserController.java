package application.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/logged-in")
    public String loggedIn() {
        return "logged_in";
    }
}
