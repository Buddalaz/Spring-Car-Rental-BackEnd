package lk.easycarrentalpvt.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaintainsDTO {
    private int maintainID;
    private String status;
    private String reason;
    private String maintainDate;
    private VehicleDTO vehicle;


}
