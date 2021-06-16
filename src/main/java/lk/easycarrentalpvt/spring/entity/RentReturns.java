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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int returnID;
    private String rDate;
    private double usedKm;
    private String reason;
    @OneToOne
    private RentOrder rentOrder;


}
