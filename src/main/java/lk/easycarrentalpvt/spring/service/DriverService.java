package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.DriverDTO;
import lk.easycarrentalpvt.spring.dto.UserDTO;

import java.util.ArrayList;

public interface DriverService {
    boolean addDriver(DriverDTO dto);

    boolean deleteDriver(String id);

    DriverDTO searchDriver(String id);

    ArrayList<DriverDTO> getAllDrivers();

    boolean updateDriver(DriverDTO dto);

    Long getDriverCount();
}
