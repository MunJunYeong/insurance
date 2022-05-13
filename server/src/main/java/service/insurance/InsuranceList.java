package service.insurance;

import domain.insurance.Insurance;

import java.util.ArrayList;

public interface InsuranceList {

    //Create
    public void addInsurance();

    //Read
    public ArrayList<Insurance> findInsuranceList();
    public Insurance findInsurance(int insuranceIdx);


    //Update

}
