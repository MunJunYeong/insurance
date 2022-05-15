package domain;

import domain.insurance.Insurance;
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
    private Long contractIdx;

    @Enumerated(EnumType.STRING)
//    @ColumnDefault("UNCHECK")
    private CheckStatus checkUwStatus;

    private LocalDateTime contractDate;

    @Enumerated(EnumType.STRING)
    private CheckUw checkUw;

    //청약서
    private String subscription;
    //제안서
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
