package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    private String city;
    private String detail;

    public Address(String city, String detail) {
        this.city = city;
        this.detail = detail;
    }
}
