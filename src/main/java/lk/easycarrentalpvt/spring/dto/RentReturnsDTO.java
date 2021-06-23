package lk.easycarrentalpvt.spring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Getter
@Setter
@ToString
//@JsonIgnoreProperties(value = "returnID",allowGetters = true,allowSetters = false)
public class RentReturnsDTO {
    private long returnID;
    private String rDate;
    private double usedKm;
    private String reason;
    private RentOrderDTO rentOrder;

}
