package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.UserDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.CustomerService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(CustomerDTO customerDTO, @RequestParam("customerID") String custId,
    @RequestParam("firstName") String fname, @RequestParam("lastName") String lname, @RequestParam("nicNumber") String nicNumber,@RequestParam("driveLicenseNumber") String driverNumber,
    @RequestParam("address") String address, @RequestParam("contactNumber") String conNumber, @RequestParam("userName") String userName, @RequestParam("password") String pass,
    @RequestPart("myFile") MultipartFile myFile) {

//        System.out.println(myFile.getOriginalFilename());

        String projectPath;
        File uploadsDir;

        try {
            projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

//            System.out.println(projectPath);

            // Let's create a folder there for uploading purposes, if not exists
            uploadsDir = new File(projectPath + "/uploads/nic");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
//            return new ResponseEntity(new StandardResponse("200"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new ValidateException("There is something wrong with the Url!!!");
        } catch (IOException e) {
//            e.printStackTrace();
            throw new ValidateException("There is something wrong Inputs");
        }

        customerDTO.setCustomerID(custId);
        customerDTO.setFirstName(fname);
        customerDTO.setLastName(lname);
        customerDTO.setNicNumber(nicNumber);
        customerDTO.setDriveLicenseNumber(driverNumber);
        customerDTO.setAddress(address);
        customerDTO.setContactNumber(conNumber);
        customerDTO.setUserName(userName);
        customerDTO.setPassword(pass);
        customerDTO.setFilePath(myFile.getOriginalFilename());

//        System.out.println(customerDTO);

        customerService.addCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO custDTO) {
        if (custDTO.getCustomerID().trim().length() <= 0 || custDTO.getAddress().trim().length() <= 0 ||
                custDTO.getFirstName().trim().length() <= 0 || custDTO.getLastName().trim().length() <= 0 ||
                custDTO.getContactNumber().trim().length() <= 0 || custDTO.getDriveLicenseNumber().trim().length() <= 0 ||
                custDTO.getNicNumber().trim().length() <= 0){
                throw new ValidateException("Filds can't be Empty");
        }
        customerService.updateCustomer(custDTO);
        return new ResponseEntity(new StandardResponse("200","success",null,0L),HttpStatus.OK);
    }

    @GetMapping(path = "/search/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO searchCustomer = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse("200","success",searchCustomer,0L),HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity getCustomerCount(){
        Long customerCount = customerService.getCustomerCount();
        return new ResponseEntity(new StandardResponse("200","success",null,customerCount), HttpStatus.OK);
    }

    @GetMapping("/ids")
    public ResponseEntity getCustomerIds(){
        ArrayList<String> customerIds = customerService.getCustomerIds();
        return new ResponseEntity(new StandardResponse("200","success",customerIds,0L),HttpStatus.OK);
    }

    @GetMapping("/search/{username}/{password}")
    public ResponseEntity searchCustomer(@PathVariable String username,@PathVariable String password){
        CustomerDTO customerDTO = customerService.searchCustomerByUserNameAndPassword(username, password);
        return new ResponseEntity(new StandardResponse("200","success",customerDTO,0L),HttpStatus.OK);
//        return "username and password";
    }

}
