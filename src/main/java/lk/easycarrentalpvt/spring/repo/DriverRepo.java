package lk.easycarrentalpvt.spring.repo;

import lk.easycarrentalpvt.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
