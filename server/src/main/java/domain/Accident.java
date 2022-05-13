package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="employeeIdx")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private LawsuitStatus lawsuitStatus;


}
