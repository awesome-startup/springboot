package info.gokit.demo.services;

import info.gokit.demo.orders.entities.Order;
import info.gokit.demo.orders.repositories.OrderRepository;
import info.gokit.demo.security.entities.User;
import info.gokit.demo.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserOrdersService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(transactionManager = "securityTransactionManager")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional(transactionManager = "ordersTransactionManager")
    public List<Order> getOrdders() {
        return orderRepository.findAll();

    }
}
