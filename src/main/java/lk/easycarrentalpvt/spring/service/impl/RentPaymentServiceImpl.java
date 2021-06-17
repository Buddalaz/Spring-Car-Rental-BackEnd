package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.RentPaymentDTO;
import lk.easycarrentalpvt.spring.entity.RentPayment;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.RentPaymentRepo;
import lk.easycarrentalpvt.spring.service.RentPaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class RentPaymentServiceImpl implements RentPaymentService {

    @Autowired
    RentPaymentRepo rentPaymentRepo;

    ModelMapper mapper;

    @Override
    public boolean addRentPayment(RentPaymentDTO paymentDTO) {
        if (rentPaymentRepo.existsById(paymentDTO.getRentPayID())){
            throw new ValidateException("payment is already exits");
        }
        rentPaymentRepo.save(mapper.map(paymentDTO, RentPayment.class));
        return true;
    }

    @Override
    public boolean deleteRentPayment(int id) {
        if (rentPaymentRepo.existsById(id)){
            throw new ValidateException("payment is already exits");
        }
        return false;
    }

    @Override
    public RentPaymentDTO searchRentPayment(int id) {
        return null;
    }

    @Override
    public ArrayList<RentPaymentDTO> getAllRentPayment() {
        return null;
    }

    @Override
    public boolean updateRentPayment(RentPaymentDTO vehicleDTO) {
        return false;
    }
}
