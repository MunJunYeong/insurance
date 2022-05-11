package domain.ex_insurance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Fire extends Insurance {
    @Id
    @GeneratedValue
    private int fireIdx;

    private int buildingCount;
    private int buildingPrice;


}
