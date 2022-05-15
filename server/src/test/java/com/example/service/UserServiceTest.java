package com.example.service;

import domain.Address;
import domain.CheckStatus;
import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;
import service.user.UserListImpl;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired EntityManager em;
    @Autowired UserListImpl userListImpl;
    @Autowired UserRepository userRepository;

    @Test
    void addUser() {
        User user = new User();
        user.setName("회원1");
        user.setAddress(new Address("서울", "영등포구 당산동"));
        user.setCheckSub(CheckStatus.UNCHECK);
        user.setCheckSug(CheckStatus.UNCHECK);
        user.setEmail("wrwer");
        user.setJob("학생");
        em.persist(user);

        userListImpl.addUser(user);
        User findUser = userListImpl.findUser(user.getUserIdx());

        Assertions.assertThat(findUser.getUserIdx()).isEqualTo(user.getUserIdx());
        Assertions.assertThat(findUser.getJob()).isEqualTo(user.getJob());
    }
}
