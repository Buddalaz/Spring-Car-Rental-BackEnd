package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentOrderDTO;
import lk.easycarrentalpvt.spring.entity.RentOrder;
import lk.easycarrentalpvt.spring.exception.NotFoundException;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.RentOrderRepo;
import lk.easycarrentalpvt.spring.service.RentOrderService;
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
public class RentOrderServiceImpl implements RentOrderService {

    @Autowired
    RentOrderRepo rentOrderRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean addRendOrder(RentOrderDTO dto) {
        rentOrderRepo.save(mapper.map(dto, RentOrder.class));
        return true;
    }

    @Override
    public boolean deleteRendOrder(String id) {
        if (rentOrderRepo.existsById(id)){
            throw new NotFoundException("Can't Delete Order");
        }
        rentOrderRepo.deleteById(id);
        return true;
    }

    @Override
    public RentOrderDTO searchRendOrder(String id) {
        Optional<RentOrder> rentOrder = rentOrderRepo.findById(id);
        if (rentOrder.isPresent()) {
            return mapper.map(rentOrder.get(), RentOrderDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentOrderDTO> getAllRendOrders() {
        List<RentOrder> orderList = rentOrderRepo.findAll();
        return mapper.map(orderList, new TypeToken<ArrayList<RentOrderDTO>>() {
        }.getType());
    }

    @Override
    public boolean updateRendOrder(RentOrderDTO dto) {
        if (rentOrderRepo.existsById(dto.getRentID())) {
            throw new ValidateException("There Is Such Rent To Update");
        }
        rentOrderRepo.save(mapper.map(dto,RentOrder.class));
        return true;
    }

    @Override
    public Long getRentOrderCount() {
        return rentOrderRepo.geyRentOrderCount();
//        return null;
    }
}
