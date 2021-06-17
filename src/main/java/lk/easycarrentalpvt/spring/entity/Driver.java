package lk.easycarrentalpvt.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    private String driveId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    @OneToMany(mappedBy = "driver",cascade = {CascadeType.ALL})
    private List<RentOrder> rentOrderList;


    public Driver(String driveId, String firstName, String lastName, String email, String contactNumber) {
        this.driveId = driveId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
    }
}
