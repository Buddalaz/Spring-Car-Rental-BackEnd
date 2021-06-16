package lk.easycarrentalpvt.spring.repo;

import lk.easycarrentalpvt.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "select count(driveId) from Driver",nativeQuery = true)
    Long getDriverCount();
}
