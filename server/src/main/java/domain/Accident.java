package domain;

import enums.LawsuitStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Accident {

    @Id
    @GeneratedValue
    private int accidentIdx;

    private LocalDateTime accidentDate;
    private String content;
    private int damagePrice;
    private int insuranceIdx;
    @Enumerated(EnumType.STRING)
    private LawsuitStatus lawsuitStatus;

    @ManyToOne
    @JoinColumn(name="userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="employeeIdx")
    private Employee employee;




}
