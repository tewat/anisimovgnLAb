package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;
import tech.reliab.course.anisimov.service.EmployeeService;

final public class EmployeeServiceImpl implements EmployeeService {
    //region ===================== Properties ======================
    private Employee employee = null;

    //region ===================== EmployeeService implementation ======================
    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public void transferTo(Employee employee, BankOffice toOffice) {

    }
}
