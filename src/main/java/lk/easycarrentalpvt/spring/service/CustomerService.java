package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    boolean addCustomer(CustomerDTO dto);

    boolean deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

    boolean updateCustomer(CustomerDTO dto);

    Long getCustomerCount();

    ArrayList<String> getCustomerIds();
}
