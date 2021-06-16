package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.config.WebAppConfig;
import lk.easycarrentalpvt.spring.config.WebRootConfig;
import lk.easycarrentalpvt.spring.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    void getCustomerCount() {
        Long customerCount = customerRepo.getCustomerCount();
        System.out.println(customerCount);
    }
}