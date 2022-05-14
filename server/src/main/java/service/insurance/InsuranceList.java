package service.insurance;

import domain.insurance.Insurance;

import java.util.List;

public interface InsuranceList {

    //Create
    public void addInsurance(Insurance insurance);

    //Read
    public List<Insurance> findInsuranceList();
    public Insurance findInsurance(Long insuranceIdx);

    public double findCarRate(int accidentRecord, int carCount, int price); // 청약서 작성 시에 넣어야하는
    public double findFireRate(int buildingCount, int buildingPrice);
    public double findHealthRate(int healthGrade);
    public double findTravelRate(int country, int period);

    //Update

}
