package info.gokit.demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void findAllUsers()  {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());

	}

	@Test
	public void findUserById()  {
		User user = userRepository.getOne(1);
		assertNotNull(user);
	}

	@Test @Ignore
	public void createUser() {
		User user = new User(null, "Paul", "paul@gmail.com");
		User savedUser = userRepository.save(user);
		User newUser = userRepository.findById(savedUser.getId()).get();
		assertEquals("Paul", newUser.getName());
		assertEquals("paul@gmail.com", newUser.getEmail());
	}

	@Test
	public void getUsersSortByName() {
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		List<User> users = userRepository.findAll(sort);
		assertNotNull(users);
	}

	@Test
	public void getUsersSortByNameAscAndIdDesc() {
		Sort.Order order1 = new Sort.Order(Sort.Direction.ASC, "name");
		Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "id");
		Sort sort = Sort.by(order1, order2);
		List<User> users = userRepository.findAll(sort);
		assertNotNull(users);
	}

	@Test
	public void getUsersByPage() {
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		int size = 25;
		int page = 0; //zero-based page index.
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<User> usersPage = userRepository.findAll(pageable);
		System.out.println(usersPage.getTotalElements()); //Returns the total amount of elements.
		System.out.println(usersPage.getTotalPages());//Returns the number of total pages.
		System.out.println(usersPage.hasNext());
		System.out.println(usersPage.hasPrevious());
		List<User> usersList = usersPage.getContent();
		assertNotNull(usersList);
	}
}
