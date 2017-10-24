package info.gokit.demo;

import org.apache.catalina.User;

import java.util.Arrays;
import java.util.List;

public class JdbcUserDAO implements UserDAO {
    @Override
    public List<String> getAllUserNames() {
        System.out.println("**** Geting usernames from RDBMS *****");
        return Arrays.asList("Paul", "John", "Jim");
    }
}
