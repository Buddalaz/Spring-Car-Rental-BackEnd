package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.DriverDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.DriverService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto){
        if (dto.getDriveId().trim().length() <=0 || dto.getFirstName().trim().length()<=0 || dto.getLastName().trim().length() <=0 ||
        dto.getEmail().trim().length()<=0 || dto.getContactNumber().trim().length() <= 0){
            throw new ValidateException("Fields Can't Be Empty");
        }
        driverService.addDriver(dto);
        return new ResponseEntity(new StandardResponse("200","success",null,0L), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto){
        if (dto.getDriveId().trim().length() <=0 || dto.getFirstName().trim().length()<=0 || dto.getLastName().trim().length() <=0 ||
                dto.getEmail().trim().length()<=0 || dto.getContactNumber().trim().length() <= 0){
            throw new ValidateException("Field's can't be Empty");
        }
        driverService.updateDriver(dto);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
//        return "Update Driver";
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDriver(String id){
        driverService.deleteDriver(id);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
//        return "Delete Driver";
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchDriver(@PathVariable String id){
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseEntity(new StandardResponse("200","success",driverDTO,0L),HttpStatus.OK);
//        return "Search Driver";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDriver(){
        ArrayList<DriverDTO> allDrivers = driverService.getAllDrivers();
        return new ResponseEntity(new StandardResponse("200","success",allDrivers,0L),HttpStatus.OK);
//        return "Get All Drivers";
    }

    @GetMapping("/count")
    public ResponseEntity getDriverCount(){
        Long driverCount = driverService.getDriverCount();
        return new ResponseEntity(new StandardResponse("200","success",null,driverCount),HttpStatus.OK);
    }

    @GetMapping("/ids")
    public ResponseEntity getDriverIds(){
        ArrayList<String> driverIds = driverService.getDriverIds();
        return new ResponseEntity(new StandardResponse("200","success",driverIds,0L),HttpStatus.OK);
    }


}
