package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RentOrder {
    @Id
    private String rentID;
    private String pickUpDate;
    private String pickOffDate;
    private String status;
    private String reason;
    private double totalFee;
    private String date;
    @ManyToOne()
    @JoinColumn(name = "customer_",referencedColumnName = "customerID")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "vehicle_",referencedColumnName = "vehicleID")
    private Vehicle vehicle;
    @ManyToOne()
    @JoinColumn(name = "driver_",referencedColumnName = "driveId")
    private Driver driver;
}
