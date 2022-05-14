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
}
