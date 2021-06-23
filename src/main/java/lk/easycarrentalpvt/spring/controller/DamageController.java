package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.DamageDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.DamageService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/damage")
@CrossOrigin
public class DamageController {

    @Autowired
    DamageService damageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDamage(@RequestBody DamageDTO damageDTO) {
        if (damageDTO.getDamageFee() <= 0 || damageDTO.getReason().trim().length() <= 0 || damageDTO.getRentReturns() == null) {
            throw new ValidateException("Fields can't be Empty");
        }
        damageService.addDamage(damageDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Damage Saved";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDamage() {
        ArrayList<DamageDTO> allDamage = damageService.getAllDamage();
        return new ResponseEntity(new StandardResponse("200", "success", allDamage, 0L), HttpStatus.OK);
//        return "Damage Saved";
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDamage(@RequestBody DamageDTO damageDTO) {
        if (damageDTO.getDamageFee() <= 0 || damageDTO.getReason().trim().length() <= 0 || damageDTO.getRentReturns() == null) {
            throw new ValidateException("Fields can't be Empty");
        }
        damageService.updateDamage(damageDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Damage Saved";
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDamage(Long id) {
        damageService.deleteDamage(id);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Damage Saved";
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchDamage(@PathVariable Long id) {
        damageService.searchDamage(id);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Damage Saved";
    }

}
