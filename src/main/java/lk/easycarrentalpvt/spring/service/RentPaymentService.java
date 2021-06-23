package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.RentPaymentDTO;
import lk.easycarrentalpvt.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface RentPaymentService {
    boolean addRentPayment(RentPaymentDTO paymentDTO);

    boolean deleteRentPayment(Long id);

    RentPaymentDTO searchRentPayment(Long id);

    ArrayList<RentPaymentDTO> getAllRentPayment();

    boolean updateRentPayment(RentPaymentDTO paymentDTO);
}
