package domain;

import domain.insurance.Insurance;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeIdx;

    private String id;
    private String name;
    private String pw;
    private String role;
    private String tel;
    public Insurance insurance;
    public Accident accident;

    public void 계약서작성(){

    }
    public  void 청약서작성(){

    }
}
