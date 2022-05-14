package service.accident;

import domain.Accident;

import java.util.ArrayList;
import java.util.List;

public interface AccidentList {

    //Create
    public void addAccident(Accident accident); //userIdx, employeeIdx,

    //Read
    public List<Accident> findAccidentList();
    public Accident findAccident(Long accidentIdx);

    //Update
    public void modifyCompensation(Long accidentIdx, int compensationPrice); //보상금액 책정
    public void modifyCheckAccident(Long accidentIdx);
    public void modifyLawsuit(Long accidentIdx);//소송 신고시

}
