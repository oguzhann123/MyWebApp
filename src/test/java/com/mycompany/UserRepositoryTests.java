package com.mycompany;
// spring data jpa test we need to use this annotation



import com.mycompany.user.User;
import com.mycompany.respository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

// data jpa test for the test class and in order to run the test against the real database we need to use it

@DataJpaTest
//in addition auto configure test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // meaning that as a test will be executed against the real database instead of the
// default in memory database and we want to keep the data committed to the database thts why wee need use this annotation rollback
@Rollback(false)
public class UserRepositoryTests {
    // we need to have a reference auto wire to the user repository
    @Autowired private UserRepository repo;
    // first test method
    @Test
    public  void testAddNew(){
        // we adding new user into the database
        User user = new User();
        // we user setting proporties for example
        user.setPassword("123456");
        user.setName("Mehmet");
        user.setSurname("KAKA");

        // call the repo save method to proceed this user object
       User savedUser = repo.save(user);  // into the database

        // we assign the return object to a new variable here stepped user and to assert this test method
        // we can use a search for a fluent

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
        // user object get id is greater than 0

    }
    // call the second test method for a listing or user in the database the second test method here

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);


        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public  void testUpdate(){
        Integer userId =18;
        Optional<User> optionalUser = repo.findById(userId);
       User user = optionalUser.get();
       user.setPassword("hello2000");
       repo.save(user);

User updateUser = repo.findById(userId).get();
Assertions.assertThat(updateUser.getPassword()).isEqualTo("hello2000");



    }

    @Test
   public  void testGet(){
        Integer  userId = 18;

        Optional<User> optionalUser = repo.findById(userId);

      Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());




    }


@Test
    public void testDelete(){
        Integer userId = 2;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();

}



}
