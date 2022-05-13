package domain.insurance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Car extends Insurance {

    @Id
    @GeneratedValue
    private int carIdx;

    private int accidentRecord;
    private int carCount;
    private String carNo;
    private int price;

}
