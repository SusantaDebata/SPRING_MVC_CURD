package com.example.mvccurd;

import jdk.nashorn.internal.runtime.options.Option;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CrudTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createTest()
    {
        User newUser=new User();
        newUser.setEmail("abc@gmail.com");
        newUser.setPassword("1234");
        newUser.setFirstName("ab");
        newUser.setLastName("cd");
        userRepository.save(newUser);
      Assertions.assertThat(newUser).isNotNull();
      Assertions.assertThat(newUser.getId()).isGreaterThan(0);

    }
    @Test
    public void retriveAll(){
        Iterable<User> user=  userRepository.findAll();       //findAll() is used to retrived data from the database
        Assertions.assertThat(user).isNotNull();
        for (User user1:user)
        {
            System.out.println(user1);
        }

}

@Test
public void updateTest()
{
    int userid =1;
    Optional<User> user=userRepository.findById(userid);
    User optionalUser=user.get();
    optionalUser.setPassword("password");
    userRepository.save(optionalUser);

    User savedUser =userRepository.findById(userid).get();
    Assertions.assertThat(savedUser.getPassword()).isEqualTo("password");

}

    @Test
    public void retriveById(){
        int userId=5;
        Optional<User> user =userRepository.findById(userId);
        User optionalUser=user.get();
        userRepository.save(optionalUser);
        Assertions.assertThat(optionalUser).isNotNull();
        if (optionalUser!=null){
            System.out.println(optionalUser);
        }
    }
    @Test
    public void deleteById(){
        int userid=4;
        Optional<User> user= userRepository.findById(userid);
        if (!user.isEmpty()){
            userRepository.deleteById(userid);
            Optional<User> user1= userRepository.findById(userid);
            Assertions.assertThat(user1).isNotPresent();
        }else {
            Optional<User> user1 = userRepository.findById(userid);
            Assertions.assertThat(user1).isPresent();
        }
    }
}
