package service.insurance;

import domain.insurance.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.InsuranceRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InsuranceListImpl implements InsuranceList{

    private final InsuranceRepository insuranceRepository;

    @Transactional
    @Override
    public void addInsurance(Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    @Override
    public List<Insurance> findInsuranceList() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance findInsurance(Long insuranceIdx) {
        return insuranceRepository.findOne(insuranceIdx);
    }

    @Override
    public double findCarRate(int accidentRecord, int carCount, int price) {
        double accidentRate = 1;
        double carCountRate = 1;
        double priceRate = 1;

        if(accidentRecord==1) {accidentRate = 1.3;}
        else if(accidentRecord==2){accidentRate = 1.5;}
        else if(accidentRecord==3){accidentRate = 1.8;}
        else {accidentRate = 2.2;}

        if(carCount==2){carCountRate = 1.6;}
        else if(carCount==3){carCountRate = 2.2;}
        else if(carCount==4) {carCountRate = 3;}
        else {carCountRate = 4;}

        if(price <= 1000) {priceRate = 1.1;}
        else if(price <= 4000){priceRate = 1.4;}
        else if(price <= 6000){priceRate = 1.6;}
        else if(price <= 10000) {priceRate = 2;}
        else {priceRate = 2.6;}

        double result = (accidentRate+carCountRate+priceRate)/3;
        return result;
    }

    @Override
    public double findFireRate(int buildingCount, int buildingPrice) {
        double buildingCountRate =1;
        double buildingPriceRate = 1;

        if(buildingCount <=3) {buildingCountRate = 2.2;}
        else if(buildingCount==5) {buildingCountRate = 3;}
        else {buildingCountRate = 7;}

        if(buildingPrice <= 10000) {buildingPriceRate = 1.1;}
        else if(buildingPrice <= 40000){buildingPriceRate = 1.6;}
        else if(buildingPrice <= 60000){buildingPriceRate = 2.4;}
        else if(buildingPrice <= 100000) {buildingPriceRate = 3.6;}
        else {buildingPriceRate = 5;}

        double result =  (buildingPriceRate+buildingPriceRate)/2;
        return result;

    }

    @Override
    public double findHealthRate(int healthGrade) {
        double healthRate = 1;

        if(healthGrade==1) {healthRate = 1;}
        else if(healthGrade==2){healthRate = 1.6;}
        else if(healthGrade==3){healthRate = 3;}
        else if(healthGrade==4) {healthRate = 5.2;}
        else {healthRate = 10;}

        return healthRate;
    }

    @Override
    public double findTravelRate(int country, int period) {
        double countryRate = 1;
        double periodRate = 1;

        if(country<=3){countryRate = 1.4;}
        else if(country<= 5){countryRate = 2;}
        else if(country<=7) {countryRate = 3;}
        else {countryRate = 4;}

        if(period <= 7) {periodRate = 1;}
        else if(period <= 14){periodRate = 1.5;}
        else if(period <= 30){periodRate = 2;}
        else if(period <= 100) {periodRate = 3;}
        else {periodRate = 5;}

        double result = (countryRate+periodRate)/2;
        return result;

    }


}
