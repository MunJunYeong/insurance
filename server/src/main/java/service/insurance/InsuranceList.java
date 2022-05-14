package service.insurance;

import domain.insurance.Insurance;

import java.util.List;

public interface InsuranceList {

    //Create
    public void addInsurance(Insurance insurance);

    //Read
    public List<Insurance> findInsuranceList();
    public Insurance findInsurance(Long insuranceIdx);


    //Update

}
