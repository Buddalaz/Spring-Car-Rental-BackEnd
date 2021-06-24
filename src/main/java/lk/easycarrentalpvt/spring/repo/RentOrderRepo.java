package lk.easycarrentalpvt.spring.repo;


import lk.easycarrentalpvt.spring.dto.RentOrderDTO;
import lk.easycarrentalpvt.spring.entity.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RentOrderRepo extends JpaRepository<RentOrder,String> {

    @Query(value = "select count(rentID) from RentOrder",nativeQuery = true)
    Long geyRentOrderCount();

//    @Query(value = "select * from RentOrder where driver_=:driverid",nativeQuery = true)
//    List<RentOrder> getDriverSceadule(@Param("driverid") String driverid);

    List<RentOrder> findByDriver_DriveId(String driverid);
}
