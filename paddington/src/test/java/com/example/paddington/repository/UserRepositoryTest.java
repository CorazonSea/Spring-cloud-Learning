package com.example.paddington.repository;

import com.example.paddington.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/*
当让 Spring Data Jpa 还有很多功能，
比如封装好的分页，可以自己定义 SQL，主从分离等等
* */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        /*userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
*/
        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb2", userRepository.findByUserNameOrEmail("bb", "dd@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));
    }
}
