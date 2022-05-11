package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int userIdx;

    @Embedded
    private Address address;

    private boolean checkSub;
    private boolean checkSug;
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
