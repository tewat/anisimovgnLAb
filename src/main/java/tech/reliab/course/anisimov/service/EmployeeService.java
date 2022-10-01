package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.Employee;

public interface EmployeeService {
    Employee getEmployee();

    void setEmployee(Employee employee);

    Boolean updateEmployee(Employee employee);

    Boolean deleteEmployee(Employee employee);
}
