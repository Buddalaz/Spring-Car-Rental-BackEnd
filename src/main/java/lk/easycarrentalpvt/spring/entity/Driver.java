package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    private int driveId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    @OneToMany(mappedBy = "driver",cascade = {CascadeType.ALL})
    private List<RentOrder> rentOrderList;

}
