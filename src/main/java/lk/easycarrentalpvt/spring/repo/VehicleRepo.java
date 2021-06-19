package lk.easycarrentalpvt.spring.repo;


import lk.easycarrentalpvt.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

    @Query(value = "select count(vehicleID) from Vehicle",nativeQuery = true)
    Long getVehicleCount();

    @Query(value = "select vehicleID from Vehicle",nativeQuery = true)
    ArrayList<String> getVehicleIds();
}
