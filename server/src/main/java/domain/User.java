package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long userIdx;

    @Embedded
    private Address address;

    //제안서 확인했는지 default-UNCHECK
    @Enumerated(EnumType.STRING)
    private CheckStatus checkSug;

    //청약서 했는지 default-UNCHECK
    @Enumerated(EnumType.STRING)
    private CheckStatus checkSub;

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
