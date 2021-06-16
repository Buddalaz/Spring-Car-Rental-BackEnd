package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.service.RentOrderService;
import lk.easycarrentalpvt.spring.service.VehicleService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import lk.easycarrentalpvt.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/easycarrentalpvt/admin")
public class AdminController {

    @Autowired
    CustomerService customerService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    RentOrderService rentOrderService;

    @GetMapping("/customer/count")
    public ResponseEntity getCustomerCount(){
        Long customerCount = customerService.getCustomerCount();
        return new ResponseEntity(new StandardResponse("200","success",null,customerCount), HttpStatus.OK);
    }

    @GetMapping("/vehicle/Count")
    public ResponseEntity getVehicleCount(){
        Long vehicleCount = vehicleService.getVehicleCount();
        return new ResponseEntity(new StandardResponse("200","success",null,vehicleCount),HttpStatus.OK);
    }

    @GetMapping("/rentOrder/Count")
    public ResponseEntity getRentOrderCount(){
        Long rentOrderCount = rentOrderService.getRentOrderCount();
        return new ResponseEntity(new StandardResponse("200","success",null,rentOrderCount),HttpStatus.OK);
    }



}
