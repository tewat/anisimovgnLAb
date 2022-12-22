package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;

public interface BankOfficeService {
    // Создать офис
    BankOffice create(BankOffice bankOffice);

    // Добавить банкомат в офис
    boolean addAtm(BankOffice bankOffice, BankAtm bankAtm);

    // Удалить банкомат из офиса
    boolean removeAtm();

    // Добавить сотрудника
    void addEmployee(BankOffice bankOffice, Employee employee);

    // Удалить сотрудника
    void removeEmployee(BankOffice bankOffice, Employee employee);

    // Внести деньги в офис
    void depositMoney(BankOffice bankOffice, double sum);

    // Снять деньги из офис
    void withdrawMoney(BankOffice bankOffice, double sum);


}
