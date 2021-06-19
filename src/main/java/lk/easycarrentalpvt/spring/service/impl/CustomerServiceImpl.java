package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.entity.Customer;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.CustomerRepo;
import lk.easycarrentalpvt.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())) {
            throw new ValidateException("Customer Already Exists");
        }
//        Customer customer = mapper.map(dto, Customer.class);
        customerRepo.save(mapper.map(dto, Customer.class));
        return true;
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new ValidateException("The Entered Customer Is Not Exits Please Enter Valid Customer");
        }
        customerRepo.deleteById(id);
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customers = customerRepo.findById(id);
        if (customers.isPresent()) {
            return mapper.map(customers.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        return mapper.map(customerList, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
//        return null;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        }
//        Customer customer = mapper.map(dto, Customer.class);
        return true;
    }

    @Override
    public Long getCustomerCount() {
        return customerRepo.getCustomerCount();
    }

    @Override
    public ArrayList<String> getCustomerIds() {
        return customerRepo.getCustomerIds();
    }
}
