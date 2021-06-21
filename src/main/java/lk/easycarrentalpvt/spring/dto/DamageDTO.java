package lk.easycarrentalpvt.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.easycarrentalpvt.spring.entity.RentReturns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = {"damageID"},allowSetters = false,allowGetters = true)
public class DamageDTO {
    private int damageID;
    private double damageFee;
    private String reason;
    private RentReturnsDTO rentReturns;
}
