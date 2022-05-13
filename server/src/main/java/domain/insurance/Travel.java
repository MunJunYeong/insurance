package domain.insurance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("D")
@Getter
@Setter
public class Travel extends Insurance {

    @Id
    @GeneratedValue
    private int travelIdx;

    private int country;
    private int period;

}
