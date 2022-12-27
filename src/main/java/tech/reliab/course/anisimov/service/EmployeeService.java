package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // Создание работника
    Employee create(Employee employee);

    // Добавить работника
    Employee addEmployee(Employee employee);

    // Получить работника по айди
    Employee getEmployeeById(String employeeId);

    // Удалить работника
    Boolean deleteEmployee(String employeeId);

    // Получить работников офиса
    List<Employee> getEmployeesByOfficeId(String officeId);

    // Получить работников банка
    List<Employee> getEmployeesByBank(String bankId);

    String stringRepresentation(String employeeId);
}
