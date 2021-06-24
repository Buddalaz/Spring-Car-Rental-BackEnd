package lk.easycarrentalpvt.spring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(value = {"rentOrder"},allowGetters = false,allowSetters = false)
public class CustomerDTO {
    private String customerID;
    private String firstName;
    private String lastName;
    private String nicNumber;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;
    private String userName;
    private String password;
//    private List<RentOrderDTO> rentOrder = new ArrayList<>();



    public CustomerDTO(String customerID) {
        this.customerID = customerID;
    }
}
