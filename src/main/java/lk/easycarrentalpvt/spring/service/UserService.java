package lk.easycarrentalpvt.spring.service;


import lk.easycarrentalpvt.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {

    boolean addUser(UserDTO dto);

    boolean deleteUser(int id);

    UserDTO searchUser(int id);

    ArrayList<UserDTO> getAllUsers();

    boolean updateUser(UserDTO dto);

}
