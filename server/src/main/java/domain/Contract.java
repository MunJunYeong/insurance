package domain;

import domain.ex_insurance.Insurance;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Contract {

    @Id
    @GeneratedValue
    private int contractIdx;

    @Enumerated(EnumType.STRING)
    private CheckUwStatus checkUwStatus;

    private LocalDateTime contractDate;

    private String subScription;
    private String suggestion;

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


//    public static Contract createContract(User user, Employee employee, Insurance insurance, int contractDate) {
//
//        Contract contract = new Contract();
//        contract.setUser(user);
//        contract.setEmployee(employee);
//        contract.setInsurance(insurance);
//        contract.setCheckUwStatus(CheckUwStatus.READY);
//        contract.setContractDate(LocalDateTime.now());
//
//        return contract;
//    }
}
