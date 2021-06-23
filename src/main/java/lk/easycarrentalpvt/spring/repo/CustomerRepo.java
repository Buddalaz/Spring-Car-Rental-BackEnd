package lk.easycarrentalpvt.spring.repo;

import lk.easycarrentalpvt.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "select count(customerID) from Customer",nativeQuery = true)
    Long getCustomerCount();

    @Query(value = "select customerID from Customer",nativeQuery = true)
    ArrayList<String> getCustomerIds();

    //native HQL
//    @Query(value = "select c.customerID from Customer c")
//    ArrayList<String> getCustomerIds();
}
