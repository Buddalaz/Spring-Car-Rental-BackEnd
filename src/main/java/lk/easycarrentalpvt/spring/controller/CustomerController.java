package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.CustomerService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomer() {
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers,0L), HttpStatus.OK);
//        return "Get All Customer";
    }

    @PostMapping()
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getCustomerID().trim().length() <= 0 || customerDTO.getAddress().trim().length() <= 0 ||
                customerDTO.getFirstName().trim().length() <= 0 || customerDTO.getLastName().trim().length() <= 0 ||
                customerDTO.getContactNumber().trim().length() <= 0 || customerDTO.getDriveLicenseNumber().trim().length() <= 0 ||
        customerDTO.getNicNumber().trim().length() <= 0) {
            throw new ValidateException("Fields Can't be empty");
        }
        customerService.addCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
//        return "Save Customer";
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
//        return "Delete Customer";
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO custDTO) {
        if (custDTO.getCustomerID().trim().length() <= 0 || custDTO.getAddress().trim().length() <= 0 ||
                custDTO.getFirstName().trim().length() <= 0 || custDTO.getLastName().trim().length() <= 0 ||
                custDTO.getContactNumber().trim().length() <= 0 || custDTO.getDriveLicenseNumber().trim().length() <= 0 ||
                custDTO.getNicNumber().trim().length() <= 0){
                throw new ValidateException("Filds can't be Empty");
        }
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
//        return "Update Customer";
    }

    @GetMapping(path = "/search/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO searchCustomer = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse("200","success",searchCustomer,0L),HttpStatus.OK);
        //        return "Search Customer";
    }

}
