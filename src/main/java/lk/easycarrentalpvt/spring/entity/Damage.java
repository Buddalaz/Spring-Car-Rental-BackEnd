package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int damageID;
    private double damageFee;
    private String reason;
    @OneToOne
    private RentReturns rentReturns;
}
