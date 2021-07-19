package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentReturnsDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.RentReturnsService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/rentReturns")
@CrossOrigin
public class RentReturnsController {

    @Autowired
    RentReturnsService rentReturnsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveRentReturns(@RequestBody RentReturnsDTO dto) {
//        if (dto.getRDate().trim().length() <= 0 || dto.getUsedKm() <= 0 || dto.getReason().trim().length() <= 0) {
//            throw new ValidateException("Field's Can't be Empty");
//        }
        System.out.println(dto);
//        rentReturnsService.addReturns(dto);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllReturns(){
        ArrayList<RentReturnsDTO> allReturns = rentReturnsService.getAllReturns();
        return new ResponseEntity(new StandardResponse("200","success",allReturns,0L),HttpStatus.OK);
    }

}
