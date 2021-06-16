package lk.easycarrentalpvt.spring.repo;

import lk.easycarrentalpvt.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String > {

    @Query(value = "select count(customerID) from Customer",nativeQuery = true)
    Long getCustomerCount();
}
