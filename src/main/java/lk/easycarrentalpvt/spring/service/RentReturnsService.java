package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentReturnsDTO;

import java.util.ArrayList;

public interface RentReturnsService {
    boolean addReturns(RentReturnsDTO dto);

    boolean deleteReturns(int id);

    RentReturnsDTO searchReturns(int id);

    ArrayList<RentReturnsDTO> getAllReturns();

    boolean updateReturns(RentReturnsDTO dto);
}
