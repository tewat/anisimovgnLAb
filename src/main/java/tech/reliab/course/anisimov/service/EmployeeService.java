package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;

public interface EmployeeService {
    // Создание работника
    Employee create(Employee employee);

    // Перевести работника в другой офис
    void transferTo(Employee employee, BankOffice toOffice);
}
