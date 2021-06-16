package lk.easycarrentalpvt.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentReturnsDTO {
    private int returnID;
    private String rDate;
    private double usedKm;
    private String reason;


}
