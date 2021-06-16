package lk.easycarrentalpvt.spring.repo;


import lk.easycarrentalpvt.spring.entity.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentOrderRepo extends JpaRepository<RentOrder,String> {

    @Query(value = "select count() from RentOrder",nativeQuery = true)
    Long geyRentOrderCount();
}
