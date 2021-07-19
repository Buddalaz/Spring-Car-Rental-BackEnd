package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentReturns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long returnID;
    private String rDate;
    private double usedKm;
    private String reason;
    @OneToOne
    @JoinColumn(name = "rentID",referencedColumnName = "rentID")
    private RentOrder rentorder;
    @OneToOne(mappedBy = "rentreturns")
    private RentPayment rentPayment;


//    private long returnID;
//    private String rDate;
//    private double usedKm;
//    private String reason;
//    @OneToOne
//    private RentOrder rentOrder;

}
