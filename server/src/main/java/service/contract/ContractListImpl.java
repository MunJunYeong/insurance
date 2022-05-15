package service.contract;

import domain.CheckUw;
import domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ContractRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class ContractListImpl implements ContractList{

    private final ContractRepository contractRepository;

    @Transactional
    @Override
    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findContractList() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findContract(Long contractIdx) {
        return contractRepository.findOne(contractIdx);
    }

    @Transactional
    @Override
    public void modifyCheckUw(Long contractIdx) {
        Contract findContract = contractRepository.findOne(contractIdx);
        findContract.setCheckUw(CheckUw.PASS);
    }

    @Transactional
    @Override
    public void modifyContractDate(int contractIdx) {
        //상의후 수정
    }
}
