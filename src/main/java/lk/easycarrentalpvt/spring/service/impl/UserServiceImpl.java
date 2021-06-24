package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.UserDTO;
import lk.easycarrentalpvt.spring.entity.User;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.UserRepo;
import lk.easycarrentalpvt.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUserID())) {
            throw new ValidateException("User Already Exists");
        }
        User user = mapper.map(dto, User.class);
        user.setUuId(UUID.randomUUID().toString());
        userRepo.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public UserDTO searchUser(Long id) {
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return mapper.map(userList, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public boolean updateUser(UserDTO dto) {
        return false;
    }

    @Override
    public UserDTO searchUserByUserNameAndPassword(String username, String password) {
        Optional<User> userNameAndPassword = userRepo.findUserByUserNameAndPassword(username, password);
        if (userNameAndPassword.isPresent()){
            return mapper.map(userNameAndPassword.get(), UserDTO.class);
        }
        return null;
    }
}
