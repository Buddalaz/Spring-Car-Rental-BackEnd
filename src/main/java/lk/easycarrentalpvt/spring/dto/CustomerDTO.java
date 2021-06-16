package lk.easycarrentalpvt.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String customerID;
    private String firstName;
    private String lasTName;
    private String nicNumber;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;
    private List<RentOrderDTO> rentOrder = new ArrayList<>();

    public CustomerDTO(String customerID, String firstName, String lasTName, String nicNumber, String driveLicenseNumber, String address, String contactNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lasTName = lasTName;
        this.nicNumber = nicNumber;
        this.driveLicenseNumber = driveLicenseNumber;
        this.address = address;
        this.contactNumber = contactNumber;
    }
}
