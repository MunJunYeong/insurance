package domain;

import enums.CheckStatus;
import enums.LawsuitStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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
    private int compensation;
    private int insuranceIdx;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("UNCHECK")
    private CheckStatus checkAccident; // 사고로써 작용하는지 1차 검증

    @Enumerated(EnumType.STRING)
    @ColumnDefault("NOT_PROCEEDING")
    private LawsuitStatus lawsuitStatus;

    @ManyToOne
    @JoinColumn(name="userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="employeeIdx")
    private Employee employee;

}
