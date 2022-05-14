package repository;

import domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final EntityManager em;

    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class)
                .getResultList();

    }
}
