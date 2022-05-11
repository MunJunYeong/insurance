package domain;

import domain.ex_insurance.Insurance;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue
    private int contractIdx;

    private boolean checkUw;
    private int contractDate;
    private String subScription;
    private String suggestion;
    private int userIdx;
    private int employeeIdx;
    private int insuranceIdx;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "employeeIdx")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "insuranceIdx")
    private Insurance insurance;

    @OneToOne
    @JoinColumn(name = "accidentIdx")
    private Accident accident;
}
