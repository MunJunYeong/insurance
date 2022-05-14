package repository;

import domain.LawsuitStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearch {

    private String userName;
    private LawsuitStatus lawsuitStatus;

}
