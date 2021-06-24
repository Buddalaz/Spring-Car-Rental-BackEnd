package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.RentPaymentDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.RentPaymentService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin
public class RentPaymentController {

    @Autowired
    RentPaymentService rentPaymentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveRentPayments(@RequestBody RentPaymentDTO rentPayDTO) {
        if (rentPayDTO.getDate().trim().length() <= 0 || rentPayDTO.getFee() <= 0 || rentPayDTO.getPayType().trim().
                length() <= 0) {
            throw new ValidateException("Feild's Can't be Empty");
        }
        rentPaymentService.addRentPayment(rentPayDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Payment Saved";
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRentPayments(@RequestBody RentPaymentDTO rentPayDTO) {
        if (rentPayDTO.getDate().trim().length() <= 0 || rentPayDTO.getFee() <= 0 || rentPayDTO.getPayType().trim().
                length() <= 0) {
            throw new ValidateException("Feild's Can't be Empty");
        }
        rentPaymentService.updateRentPayment(rentPayDTO);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Payment Updated";
    }

    @GetMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchRentPayments(@PathVariable long id) {
        RentPaymentDTO paymentDTO = rentPaymentService.searchRentPayment(id);
        return new ResponseEntity(new StandardResponse("200", "success", paymentDTO, 0L), HttpStatus.OK);
//        return "Payment Search";
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteRentPayments(long id) {
        rentPaymentService.deleteRentPayment(id);
        return new ResponseEntity(new StandardResponse("200", "success", null, 0L), HttpStatus.OK);
//        return "Payment Deleted";
    }

    @GetMapping
    public ResponseEntity getAllRentPayments() {
        ArrayList<RentPaymentDTO> allRentPayment = rentPaymentService.getAllRentPayment();
        return new ResponseEntity(new StandardResponse("200", "success", allRentPayment, 0L), HttpStatus.OK);
//        return "Payments";
    }

}
