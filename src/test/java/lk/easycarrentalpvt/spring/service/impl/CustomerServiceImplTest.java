package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.config.WebAppConfig;
import lk.easycarrentalpvt.spring.config.WebRootConfig;
import lk.easycarrentalpvt.spring.entity.Customer;
import lk.easycarrentalpvt.spring.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void getCustomerId(){
//        ArrayList<String> ids = customerRepo.getCustomerIds();
////        System.out.println(ids);
//        for (String id : ids) {
//            System.out.println(id);
//        }
        ArrayList<String> customerIds = customerRepo.getCustomerIds();
        for (String id : customerIds) {
            System.out.println(id);
        }
        }

//    @Test
//    public void getCustomerCount(){
//        Long customerCount = customerRepo.getCustomerCount();
//        System.out.println(customerCount);
//    }

}