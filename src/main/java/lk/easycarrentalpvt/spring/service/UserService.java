package lk.easycarrentalpvt.spring.service;


import lk.easycarrentalpvt.spring.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    boolean addUser(UserDTO dto);

    boolean deleteUser(Long id);

    UserDTO searchUser(Long id);

    ArrayList<UserDTO> getAllUsers();

    boolean updateUser(UserDTO dto);

    UserDTO searchUserByUserNameAndPassword(String username,String password);

}
