package repository;

import domain.Accident;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccidentRepository {

    private final EntityManager em;

    public void save(Accident accident) {
        if (accident.getAccidentIdx() == null) {
            em.persist(accident);
        }
    }

    public Accident findOne(Long id) {
        return em.find(Accident.class, id);
    }

    public List<Accident> findAll() {
        return em.createQuery("select a from Accident a", Accident.class)
                .getResultList();
    }
}
