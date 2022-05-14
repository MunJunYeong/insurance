package domain;

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
    private Long accidentIdx;

    private LocalDateTime accidentDate;
    private String content;
    private int damagePrice;
    private int compensationPrice;

    private Long insuranceIdx;

//    @ColumnDefault("UNCHECK")
    @Enumerated(EnumType.STRING)
    private CheckStatus checkAccident; // 사고로써 작용하는지 1차 검증

 //    @ColumnDefault("NOT_PROCEEDING")
    @Enumerated(EnumType.STRING)
    private LawsuitStatus lawsuitStatus;

    @ManyToOne
    @JoinColumn(name="userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="employeeIdx")
    private Employee employee;

}
