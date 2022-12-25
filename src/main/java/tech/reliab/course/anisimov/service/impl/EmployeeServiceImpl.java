package tech.reliab.course.anisimov.service.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;
import tech.reliab.course.anisimov.service.BankOfficeService;
import tech.reliab.course.anisimov.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final public class EmployeeServiceImpl implements EmployeeService {
    //region ===================== Properties ======================
    private Map<String, Employee> employeeMap = new HashMap<>();

    //region ===================== DI ======================
    @NotNull public BankOfficeService bankOfficeService;

    //region ===================== EmployeeService implementation ======================
    @Override
    public @Nullable Employee create(@NotNull Employee employee) {
        return this.addEmployee(new Employee(employee));
    }

    @Override
    public @Nullable Employee addEmployee(@NotNull Employee employee) {
        if (this.employeeMap.containsKey(employee.getId())) { return null; }

        BankOffice bankOffice = employee.getOffice();
        if (bankOffice != null && this.bankOfficeService.addEmployee(bankOffice.getId(), employee)) {
            this.employeeMap.put(employee.getId(), employee);
            return employee;
        }

        return employee;
    }

    @Override
    public @Nullable Employee getEmployeeById(@NotNull String employeeId) {
        return this.employeeMap.get(employeeId);
    }

    @Override
    public @NotNull Boolean deleteEmployee(@NotNull String employeeId) {
        Employee employee = this.getEmployeeById(employeeId);
        if (employee == null) { return false; }

        this.bankOfficeService.removeEmployee(employee.getOffice().getId(), employeeId);
        return this.employeeMap.remove(employeeId) != null;
    }

    @Override
    public @NotNull List<Employee> getEmployeesByOfficeId(@NotNull String officeId) {
        return this.employeeMap.values()
                .stream()
                .filter(employee -> Objects.equals(employee.getOffice().getId(), officeId))
                .toList();
    }

    @Override
    public @NotNull List<Employee> getEmployeesByBank(@NotNull String bankId) {
        return this.employeeMap.values()
                .stream()
                .filter(employee -> Objects.equals(employee.getBankOfWork().getId(), bankId))
                .toList();
    }
}
