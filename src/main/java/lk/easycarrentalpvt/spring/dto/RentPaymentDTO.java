package lk.easycarrentalpvt.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentPaymentDTO {
    private int rentPayID;
    private String date;
    private double fee;
    private String payType;
    private RentOrderDTO rentOrder;
}
