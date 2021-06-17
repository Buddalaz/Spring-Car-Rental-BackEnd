package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.RentOrderDTO;
import lk.easycarrentalpvt.spring.service.RentOrderService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rentOrder")
@CrossOrigin
public class RentOrderController {

    @Autowired
    RentOrderService rentOrderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addOrderRent(@RequestBody RentOrderDTO rentOrderDTO){
        rentOrderService.addRendOrder(rentOrderDTO);
        return new ResponseEntity(new StandardResponse("200","success",null,0L), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrderRent(@RequestBody RentOrderDTO rentOrderDTO){
        rentOrderService.addRendOrder(rentOrderDTO);
        return new ResponseEntity(new StandardResponse("200","success",null,0L), HttpStatus.OK);
    }


}
