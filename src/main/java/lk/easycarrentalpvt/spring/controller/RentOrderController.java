package lk.easycarrentalpvt.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/easycarrentalpvt/rentOrder")
public class RentOrderController {

    @PostMapping
    public String addOrderRent(){
        return "Order Added Successfully";
    }

}
