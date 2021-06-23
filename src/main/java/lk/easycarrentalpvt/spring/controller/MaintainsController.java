package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.MaintainsDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.MaintainsService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/maintains")
@CrossOrigin
public class MaintainsController {

    @Autowired
    MaintainsService maintainsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveMaintains(@RequestBody MaintainsDTO maintainsDTO) {
        if (maintainsDTO.getStatus().trim().length() <= 0 || maintainsDTO.getReason().trim().length() <= 0 ||
                maintainsDTO.getMaintainDate().trim().length() <= 0 || maintainsDTO.getVehicle() == null) {
            throw new ValidateException("Fields can't be empty");
        }
        maintainsService.addMaintains(maintainsDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Maintains Saved";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMaintains() {
        ArrayList<MaintainsDTO> allMaintains = maintainsService.getAllMaintains();
        return new ResponseEntity(new StandardResponse("200", "success", allMaintains, 0L), HttpStatus.OK);
        //        return "Maintains Saved";
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity UpdateMaintains(@RequestBody MaintainsDTO maintainsDTO) {
        if (maintainsDTO.getStatus().trim().length() <= 0 || maintainsDTO.getReason().trim().length() <= 0 ||
                maintainsDTO.getMaintainDate().trim().length() <= 0 || maintainsDTO.getVehicle() == null) {
            throw new ValidateException("Fields can't be empty");
        }
        maintainsService.updateMaintains(maintainsDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Maintains Saved";
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMaintains(Long id) {
        maintainsService.deleteMaintains(id);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Maintains Saved";
    }

    @GetMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMaintains(@PathVariable Long id) {
        MaintainsDTO searchMaintains = maintainsService.searchMaintains(id);
        return new ResponseEntity(new StandardResponse("200", "success", searchMaintains, 0L), HttpStatus.OK);
//        return "Maintains Saved";
    }
}
