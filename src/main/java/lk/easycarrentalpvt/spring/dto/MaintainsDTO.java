package lk.easycarrentalpvt.spring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(value = {"maintainID"},allowGetters = true,allowSetters = false)
public class MaintainsDTO {
    private long maintainID;
    private String status;
    private String reason;
    private String maintainDate;
    private VehicleDTO vehicle;


}
