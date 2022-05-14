package service.employee;

import domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeListImpl implements EmployeeList{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findSalesmanList() {
        return employeeRepository.findAll();
    }
}
