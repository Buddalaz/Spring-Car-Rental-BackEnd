package lk.easycarrentalpvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maintains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maintainID;
    private String status;
    private String reason;
    private String maintainDate;
    @OneToOne
    private Vehicle vehicle;
}
