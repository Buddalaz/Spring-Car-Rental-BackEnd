package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rentPayID;
    private String date;
    private double fee;
    private String payType;
    @OneToOne
    @JoinColumn(name = "returnID",referencedColumnName = "returnID")
    private RentReturns rentreturns;

//    private long rentPayID;
//    private String date;
//    private double fee;
//    private String payType;
}
