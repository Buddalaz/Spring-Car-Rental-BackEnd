package lk.easycarrentalpvt.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private int driveId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private RentOrderDTO rentOrderDTO;
}
