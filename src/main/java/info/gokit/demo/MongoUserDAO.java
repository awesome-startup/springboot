package info.gokit.demo;

import java.util.Arrays;
import java.util.List;

public class MongoUserDAO implements UserDAO {
    @Override
    public List<String> getAllUserNames() {
        System.out.println("**** Geting usernames from MongoDB *****");
        return Arrays.asList("Bond", "James", "Rob");
    }
}
