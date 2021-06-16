package lk.easycarrentalpvt.spring.repo;


import lk.easycarrentalpvt.spring.entity.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentPaymentRepo extends JpaRepository<RentPayment,Integer> {
}
