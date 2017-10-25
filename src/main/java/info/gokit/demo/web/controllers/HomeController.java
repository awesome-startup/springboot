package info.gokit.demo.web.controllers;

import info.gokit.demo.services.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @Autowired
    private UserOrdersService userOrdersService;

    @RequestMapping( value = {"/", "/app/users"}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("users", userOrdersService.getUsers());
        model.addAttribute("orders", userOrdersService.getOrdders());
        return "users";
    }
}
