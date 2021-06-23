package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentPaymentDTO;
import lk.easycarrentalpvt.spring.entity.RentPayment;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.RentPaymentRepo;
import lk.easycarrentalpvt.spring.service.RentPaymentService;
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
    public boolean updateRentPayment(RentPaymentDTO paymentDTO) {
        if (rentPaymentRepo.existsById(paymentDTO.getRentPayID())){
            rentPaymentRepo.save(mapper.map(paymentDTO,RentPayment.class));
        }
        return true;
    }

    @Override
    public boolean deleteRentPayment(Long id) {
        if (!rentPaymentRepo.existsById(id)){
            throw new ValidateException("payment is already exits");
        }
        rentPaymentRepo.deleteById(id);
        return true;
    }

    @Override
    public RentPaymentDTO searchRentPayment(Long id) {
        Optional<RentPayment> rentPayment = rentPaymentRepo.findById(id);
        if (rentPayment.isPresent()){
            return mapper.map(rentPayment.get(),RentPaymentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentPaymentDTO> getAllRentPayment() {
        List<RentPayment> rentPayments = rentPaymentRepo.findAll();
        return mapper.map(rentPayments,new TypeToken<ArrayList<RentPaymentDTO>>() {
        }.getType());
//        return null;
    }
}
