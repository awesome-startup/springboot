package info.gokit.demo.controllers;

import info.gokit.demo.orders.entities.Order;
import info.gokit.demo.security.entities.User;
import info.gokit.demo.services.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserOrdersController {

    @Autowired
    private UserOrdersService userOrdersService;

    @ResponseBody
    @GetMapping("/users")
    public List<User> listUsers() {
        return userOrdersService.getUsers();
    }

    @ResponseBody
    @GetMapping("/orders")
    public List<Order> listOrders() {
        return userOrdersService.getOrdders();
    }
}
