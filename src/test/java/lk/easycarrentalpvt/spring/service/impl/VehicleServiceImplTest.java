package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.config.WebAppConfig;
import lk.easycarrentalpvt.spring.config.WebRootConfig;
import lk.easycarrentalpvt.spring.repo.VehicleRepo;
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
class VehicleServiceImplTest {

    @Autowired
    VehicleRepo vehicleRepo;

    @Test
    public void getVehiGeneralCount(){
        Long vehGeneralCount = vehicleRepo.getVehGeneralCount();
        System.out.println(vehGeneralCount);
    }

    @Test
    public void getVehiPremiumCount(){
        Long vehPremiumCount = vehicleRepo.getVehPremiumCount();
        System.out.println(vehPremiumCount);
    }

    @Test
    public void getVehiLuxuryCount(){
        Long vehLuxuryCount = vehicleRepo.getVehLuxuryCount();
        System.out.println(vehLuxuryCount);
    }
}