package domain.insurance;

import domain.Accident;
import domain.Contract;
import domain.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Insurance {

    @Id
    @GeneratedValue
    private Long insuranceIdx;

    private String content;
    private int fee;
    private int maxReward;
    private int period;
    private int rate;
    private int employeeIdx;

    public Contract contract;
    public Accident accident;

    @ManyToOne
    @JoinColumn(name="employeeIdx")
    private Employee employee;

}
