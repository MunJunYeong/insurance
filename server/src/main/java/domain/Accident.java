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

    //    private int employeeIdx;
    //    private int userIdx;

    //add - 양방향 참조 후 추가
    public void addAccident(Accident accident) {
    }
}
