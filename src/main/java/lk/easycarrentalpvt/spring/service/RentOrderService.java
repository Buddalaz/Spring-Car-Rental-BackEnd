package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentOrderDTO;

import java.util.ArrayList;

public interface RentOrderService {

    boolean addRendOrder(RentOrderDTO dto);

    boolean deleteRendOrder(String id);

    RentOrderDTO searchRendOrder(String id);

    ArrayList<RentOrderDTO> getAllRendOrders();

    boolean updateRendOrder(RentOrderDTO dto);

    Long getRentOrderCount();
}
