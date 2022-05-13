package domain;

import enums.CheckStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int userIdx;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("UNCHECK")
    private CheckStatus checkSub;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("UNCHECK")
    private CheckStatus checkSug;

    private String email;
    private String id;
    private String job;
    private String name;
    private String pw;
    private boolean sex;
    private String ssn;
    private String tel;
    public Contract contract;
    public Accident accident;

}
