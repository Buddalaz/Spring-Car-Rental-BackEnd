package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.VehicleDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.VehicleService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO vehiDTO) {
        if (vehiDTO.getVehicleID().trim().length() <= 0 || vehiDTO.getBrand().trim().length() <= 0
                || vehiDTO.getModel().trim().length() <= 0 || vehiDTO.getType().trim().length() <= 0
                || vehiDTO.getExtraFee() <= 0 || vehiDTO.getRegNumber().trim().length() <= 0
                || vehiDTO.getColor().trim().length() <= 0 || vehiDTO.getPassNumber().trim().length() <= 0
                || vehiDTO.getTransmissionType().trim().length() <= 0 || vehiDTO.getFuelType().trim().length() <= 0
                || vehiDTO.getDailyRent() <= 0 || vehiDTO.getMonthlyRent() <= 0
                || vehiDTO.getDailyKM().trim().length() <= 0 || vehiDTO.getMonthlyKM().trim().length() <= 0) {
            throw new ValidateException("Field's Can't be Empty");
        }
        service.addVehicle(vehiDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO vehiDTO) {
        if (vehiDTO.getVehicleID().trim().length() <= 0 || vehiDTO.getBrand().trim().length() <= 0
                || vehiDTO.getModel().trim().length() <= 0 || vehiDTO.getType().trim().length() <= 0
                || vehiDTO.getExtraFee() <= 0 || vehiDTO.getRegNumber().trim().length() <= 0
                || vehiDTO.getColor().trim().length() <= 0 || vehiDTO.getPassNumber().trim().length() <= 0
                || vehiDTO.getTransmissionType().trim().length() <= 0 || vehiDTO.getFuelType().trim().length() <= 0
                || vehiDTO.getDailyRent() <= 0 || vehiDTO.getMonthlyRent() <= 0
                || vehiDTO.getDailyKM().trim().length() <= 0 || vehiDTO.getMonthlyKM().trim().length() <= 0) {
            throw new ValidateException("Field's Can't be Empty");
        }
        service.updateVehicle(vehiDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteVehicle(@RequestParam String id) {
        service.deleteVehicle(id);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
    }

    @GetMapping(path = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchVehicle(@PathVariable String id) {
        VehicleDTO vehicleDTO = service.searchVehicle(id);
        return new ResponseEntity(new StandardResponse("200", "success", vehicleDTO, 0L), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllVehicle() {
        ArrayList<VehicleDTO> allVehicles = service.getAllVehicles();
        return new ResponseEntity(new StandardResponse("200", "success", allVehicles, 0L), HttpStatus.OK);
    }
}
