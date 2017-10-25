package info.gokit.demo;

import info.gokit.demo.orders.entities.Order;
import info.gokit.demo.orders.repositories.OrderRepository;
import info.gokit.demo.security.entities.User;
import info.gokit.demo.security.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());

    }

    @Test
    public void findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        assertNotNull(orders);
        assertTrue(!orders.isEmpty());

    }

}
