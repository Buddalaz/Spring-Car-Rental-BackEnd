package lk.easycarrentalpvt.spring.service;

import lk.easycarrentalpvt.spring.dto.CustomerDTO;
import lk.easycarrentalpvt.spring.dto.RentOrderDTO;
import lk.easycarrentalpvt.spring.entity.RentOrder;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface RentOrderService {

    boolean addRendOrder(RentOrderDTO dto);

    boolean deleteRendOrder(String id);

    RentOrderDTO searchRendOrder(String id);

    ArrayList<RentOrderDTO> getAllRendOrders();

    boolean updateRendOrder(RentOrderDTO dto);

    Long getRentOrderCount();
}
