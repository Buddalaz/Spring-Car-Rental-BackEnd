package lk.easycarrentalpvt.spring.repo;


import lk.easycarrentalpvt.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

    @Query(value = "select count(vehicleID) from Vehicle",nativeQuery = true)
    Long getVehicleCount();
}
