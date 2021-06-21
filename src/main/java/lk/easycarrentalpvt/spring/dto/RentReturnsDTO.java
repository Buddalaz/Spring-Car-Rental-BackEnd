package lk.easycarrentalpvt.spring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = "returnID",allowGetters = true,allowSetters = false)
public class RentReturnsDTO {
    private int returnID;
    private String rDate;
    private double usedKm;
    private String reason;
//    private RentOrderDTO rentOrder;

}
