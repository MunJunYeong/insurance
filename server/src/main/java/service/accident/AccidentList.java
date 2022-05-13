package service.accident;

import domain.Accident;

import java.util.ArrayList;

public interface AccidentList {

    //Create
    public void addAccident(); //userIdx, employeeIdx,

    //Read
    public ArrayList<Accident> findAccidentList();
    public Accident findAccident();

    //Update
    public void modifyCompensation(int accidentIdx); //보상금액 책정
    public void modifyCheckAccident(int accidentIdx);
    public void modifyLawsuit(int accidentIdx);//소송 신고시

}
