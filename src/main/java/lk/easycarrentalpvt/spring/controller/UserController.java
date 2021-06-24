package lk.easycarrentalpvt.spring.controller;

import lk.easycarrentalpvt.spring.dto.UserDTO;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.service.UserService;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto){
        if (dto.getUserName().trim().length() <= 0 || dto.getPassword().trim().length() <= 0){
            throw new ValidateException("fields Can't Be Empty");
        }
        userService.addUser(dto);
        return new ResponseEntity(new StandardResponse("200","success",null,0L), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers(){
        ArrayList<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity(new StandardResponse("200","success",allUsers,0L),HttpStatus.OK);
    }

    @GetMapping("/search/{username}/{password}")
    public ResponseEntity searchUser(@PathVariable String username,@PathVariable String password){
        UserDTO userDTO = userService.searchUserByUserNameAndPassword(username, password);
        return new ResponseEntity(new StandardResponse("200","success",userDTO,0L),HttpStatus.OK);
//        return "username and password";
    }

}
