package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Accident {

    @Id
    @GeneratedValue
    private int accidentIdx;

    private int accidentDate;
    private String content;
    private int damagePrice;
    private int employeeIdx;
    private int insuranceIdx;
    private boolean lawsuit;
    private int userIdx;

    @ManyToOne
    @JoinColumn(name="userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="employeeIdx")
    private Employee employee;
}
