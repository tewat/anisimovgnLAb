package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.Employee;
import tech.reliab.course.anisimov.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    //region ===================== Properties ======================
    private Employee employee = null;

    //region ===================== EmployeeService implementation ======================
    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        if (this.employee == employee) {
            setEmployee(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteEmployee(Employee employee) {
        if (this.employee == employee) {
            this.employee = null;
            return true;
        } else {
            return false;
        }
    }
}
