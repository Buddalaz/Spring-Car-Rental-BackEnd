package lk.easycarrentalpvt.spring.repo;


import lk.easycarrentalpvt.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

    @Query(value = "select vehicleID from Vehicle",nativeQuery = true)
    ArrayList<String> getVehicleIds();

    @Query(value = "select sum(qyt) from Vehicle",nativeQuery = true)
    Long getVehicleCount();

    @Query(value = "select count(type) from Vehicle where type='General'",nativeQuery = true)
    Long getVehGeneralCount();

    @Query(value = "select count(type) from Vehicle where type='Premium'",nativeQuery = true)
    Long getVehPremiumCount();

    @Query(value = "select count(type) from Vehicle where type='Luxury'",nativeQuery = true)
    Long getVehLuxuryCount();
}
