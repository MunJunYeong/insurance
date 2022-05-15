package repository;

import domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractRepository {

    private final EntityManager em;

    public void save(Contract contract) {
        if (contract.getContractIdx() == null) {
            em.persist(contract);
        }
    }

    public Contract findOne(Long id) {
        return em.find(Contract.class, id);
    }

    public List<Contract> findAll() {
        return em.createQuery("select a from Contract a", Contract.class)
                .getResultList();
    }

}
