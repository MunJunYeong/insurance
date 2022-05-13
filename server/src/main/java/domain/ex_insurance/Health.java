package domain.ex_insurance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("C")
@Getter
@Setter
public class Health extends Insurance {

    @Id
    @GeneratedValue
    private int healthIdx;

    private int healthGrade;

}
