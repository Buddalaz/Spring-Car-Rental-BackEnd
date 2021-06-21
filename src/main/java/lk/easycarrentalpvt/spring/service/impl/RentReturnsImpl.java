package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentReturnsDTO;
import lk.easycarrentalpvt.spring.entity.RentReturns;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.repo.RentReturnsRepo;
import lk.easycarrentalpvt.spring.service.RentReturnsService;
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
public class RentReturnsImpl implements RentReturnsService {

    @Autowired
    RentReturnsRepo returnsRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean addReturns(RentReturnsDTO dto) {
        if (returnsRepo.existsById(dto.getReturnID())){
            throw new ValidateException("Return Already Exists");
        }
        returnsRepo.save(mapper.map(dto, RentReturns.class));
        return true;
    }

    @Override
    public boolean deleteReturns(int id) {
        if (!returnsRepo.existsById(id)){
            throw new ValidateException("Please Enter Valid Exists Id");
        }
        returnsRepo.deleteById(id);
        return true;
    }

    @Override
    public RentReturnsDTO searchReturns(int id) {
        Optional<RentReturns> rentReturns = returnsRepo.findById(id);
        if (rentReturns.isPresent()){
            return mapper.map(rentReturns.get(),RentReturnsDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentReturnsDTO> getAllReturns() {
        List<RentReturns> rentReturns = returnsRepo.findAll();
        return mapper.map(rentReturns,new TypeToken<ArrayList<RentReturnsDTO>>() {
        }.getType());
    }

    @Override
    public boolean updateReturns(RentReturnsDTO dto) {
        if (returnsRepo.existsById(dto.getReturnID())){
            returnsRepo.save(mapper.map(dto,RentReturns.class));
        }
        return true;
    }
}
