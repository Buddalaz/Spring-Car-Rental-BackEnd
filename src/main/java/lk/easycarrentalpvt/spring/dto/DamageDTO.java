package lk.easycarrentalpvt.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DamageDTO {
    private int damageID;
    private double damageFee;
    private String reason;
}
