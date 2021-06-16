package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
    boolean addVehicle(VehicleDTO vehicleDTO);

    boolean deleteVehicle(String id);

    VehicleDTO searchVehicle(String id);

    ArrayList<VehicleDTO> getAllVehicles();

    boolean updateVehicle(VehicleDTO vehicleDTO);

    Long getVehicleCount();
}
