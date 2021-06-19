package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.DriverDTO;
import lk.easycarrentalpvt.spring.entity.Driver;
import lk.easycarrentalpvt.spring.exception.NotFoundException;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.DriverRepo;
import lk.easycarrentalpvt.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriveId())) {
            throw new ValidateException("Driver is Already Exits");
        }
//        Driver driver = new Driver(dto.getDriveId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getContactNumber());
        driverRepo.save(mapper.map(dto, Driver.class));
        return true;
    }

    @Override
    public boolean deleteDriver(String id) {
        if (!driverRepo.existsById(id)) {
            throw new NotFoundException("Customer Not Found");
        }
        driverRepo.deleteById(id);
        return true;
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> searchDrivers = driverRepo.findById(id);
        if (searchDrivers.isPresent()) {
            return mapper.map(searchDrivers.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public boolean updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriveId())) {
            driverRepo.save(mapper.map(dto, Driver.class));
        }
        return true;
    }

    @Override
    public Long getDriverCount() {
        return driverRepo.getDriverCount();
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> driverList = driverRepo.findAll();
        return mapper.map(driverList, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }
}
