package lk.easycarrentalpvt.spring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIgnoreProperties(value = "rentPayID",allowGetters = true,allowSetters = false)
public class RentPaymentDTO {
    private long rentPayID;
    private String date;
    private double fee;
    private String payType;
    private RentOrderDTO rentOrder;
}
