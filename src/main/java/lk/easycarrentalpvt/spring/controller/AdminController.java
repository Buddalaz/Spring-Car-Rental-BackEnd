package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.RentOrderDTO;
import lk.easycarrentalpvt.spring.service.DriverService;
import lk.easycarrentalpvt.spring.service.RentOrderService;
import lk.easycarrentalpvt.spring.service.VehicleService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import lk.easycarrentalpvt.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/easycarrentalpvt/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    CustomerService customerService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    RentOrderService rentOrderService;

    @Autowired
    DriverService driverService;

    @GetMapping("/customer/count")
    public ResponseEntity getCustomerCount(){
        Long customerCount = customerService.getCustomerCount();
        return new ResponseEntity(new StandardResponse("200","success",null,customerCount), HttpStatus.OK);
    }

    @GetMapping("/vehicle/count")
    public ResponseEntity getVehicleCount(){
        Long vehicleCount = vehicleService.getVehicleCount();
        return new ResponseEntity(new StandardResponse("200","success",null,vehicleCount),HttpStatus.OK);
    }

    @GetMapping("/rentOrder/count")
    public ResponseEntity getRentOrderCount(){
        Long rentOrderCount = rentOrderService.getRentOrderCount();
        return new ResponseEntity(new StandardResponse("200","success",null,rentOrderCount),HttpStatus.OK);
    }

    @GetMapping("/driver/count")
    public ResponseEntity getDriverCount(){
        Long driverCount = driverService.getDriverCount();
        return new ResponseEntity(new StandardResponse("200","success",null,driverCount),HttpStatus.OK);
    }

    @GetMapping("/rentOrder")
    public ResponseEntity getAllOrders(){
        ArrayList<RentOrderDTO> allRendOrders = rentOrderService.getAllRendOrders();
        return new ResponseEntity(new StandardResponse("200","success",allRendOrders,0L),HttpStatus.OK);
    }


}
