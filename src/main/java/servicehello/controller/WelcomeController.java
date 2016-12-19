package servicehello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lion on 19.12.16.
 */

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("welcome");
    }
}
