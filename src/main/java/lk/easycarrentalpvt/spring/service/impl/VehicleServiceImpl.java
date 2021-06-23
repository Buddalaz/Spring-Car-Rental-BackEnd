package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.entity.Vehicle;
import lk.easycarrentalpvt.spring.service.VehicleService;
import lk.easycarrentalpvt.spring.dto.VehicleDTO;
import lk.easycarrentalpvt.spring.exception.NotFoundException;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.VehicleRepo;
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
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleID())) {
            throw new ValidateException("Vehicle is Already Exists");
        }
        vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
        return true;
    }

    @Override
    public boolean deleteVehicle(String id) {
        if (!vehicleRepo.existsById(id)) {
            throw new ValidateException("Enter Valid Vehicle Id");
        }
        vehicleRepo.deleteById(id);
        return true;
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if (vehicle.isPresent()) {
            return mapper.map(vehicle.get(), VehicleDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepo.findAll();
        return mapper.map(vehicleList, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
//        return null;
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleID())) {
            vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
        }
        return true;
    }

    @Override
    public Long getVehicleCount() {
        return vehicleRepo.getVehicleCount();
    }

    @Override
    public Long getVehGeneralCount() {
        return vehicleRepo.getVehGeneralCount();
    }

    @Override
    public Long getVehPremiumCount() {
        return vehicleRepo.getVehPremiumCount();
    }

    @Override
    public Long getVehLuxuryCount() {
        return vehicleRepo.getVehLuxuryCount();
    }

    @Override
    public ArrayList<String> getVehicleIds() {
        return vehicleRepo.getVehicleIds();
    }


}
