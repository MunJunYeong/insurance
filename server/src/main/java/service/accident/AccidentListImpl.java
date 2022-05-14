package service.accident;

import domain.Accident;
import domain.CheckStatus;
import domain.LawsuitStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccidentRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class AccidentListImpl implements AccidentList{

    private final AccidentRepository accidentRepository;

    @Transactional
    @Override
    public void addAccident(Accident accident) {
        accidentRepository.save(accident);
    }

    @Override
    public List<Accident> findAccidentList() {
        return accidentRepository.findAll();
    }

    @Override
    public Accident findAccident(Long accidentIdx) {
        return accidentRepository.findOne(accidentIdx);
    }

    @Transactional
    @Override
    public void modifyCompensation(Long accidentIdx, int compensationPrice) {
        Accident findAccident = accidentRepository.findOne(accidentIdx);
        findAccident.setCompensationPrice(compensationPrice);
    }

    @Transactional
    @Override
    public void modifyCheckAccident(Long accidentIdx) {
        Accident findAccident = accidentRepository.findOne(accidentIdx);
        findAccident.setCheckAccident(CheckStatus.CHECK);
    }

    @Transactional
    @Override
    public void modifyLawsuit(Long accidentIdx) {
        Accident findAccident = accidentRepository.findOne(accidentIdx);
        findAccident.setLawsuitStatus(LawsuitStatus.PROCEEDING);
    }
}
