package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    private String vehicleID;
    private String brand;
    private String model;
    private String type;
    private double extraFee;
    private String regNumber;
    private String color;
    private String passNumber;
    private String transmissionType;
    private String fuelType;
    private double dailyRent;
    private double monthlyRent;
    private String dailyKM;
    private String monthlyKM;
    @OneToMany(mappedBy = "vehicle",cascade = {CascadeType.ALL})
    private List<RentOrder> rentOrder;

    public Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }
}
