package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.config.WebAppConfig;
import lk.easycarrentalpvt.spring.config.WebRootConfig;
import lk.easycarrentalpvt.spring.entity.RentOrder;
import lk.easycarrentalpvt.spring.repo.RentOrderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class RentOrderServiceImplTest {

    @Autowired
    RentOrderRepo rentOrderRepo;

    @Test
    public void getDriverSceadule(){
        List<RentOrder> driveId = rentOrderRepo.findByDriver_DriveId("D001");
        System.out.println(driveId);
    }
}