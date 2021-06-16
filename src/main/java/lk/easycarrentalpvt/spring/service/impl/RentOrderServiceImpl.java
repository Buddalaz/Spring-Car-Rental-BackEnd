package lk.easycarrentalpvt.spring.service.impl;

import lk.easycarrentalpvt.spring.repo.RentOrderRepo;
import lk.easycarrentalpvt.spring.service.RentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RentOrderServiceImpl implements RentOrderService {

    @Autowired
    RentOrderRepo rentOrderRepo;

    @Override
    public Long getRentOrderCount() {
        return rentOrderRepo.geyRentOrderCount();
//        return null;
    }
}
