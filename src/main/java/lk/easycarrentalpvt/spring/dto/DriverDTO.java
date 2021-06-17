package lk.easycarrentalpvt.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driveId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private RentOrderDTO rentOrderDTO;

    public DriverDTO(String driveId, String firstName, String lastName, String email, String contactNumber) {
        this.driveId = driveId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
    }
}
