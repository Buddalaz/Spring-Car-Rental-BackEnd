package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.config.WebAppConfig;
import lk.easycarrentalpvt.spring.config.WebRootConfig;
import lk.easycarrentalpvt.spring.entity.User;
import lk.easycarrentalpvt.spring.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @Autowired
    UserRepo userRepo;

    @Test
    public void searchUserByUsernameAndPassword(){
        Optional<User> nameAndPassword = userRepo.findUserByUserNameAndPassword("admin", "1234");
        System.out.println(nameAndPassword);
    }

}