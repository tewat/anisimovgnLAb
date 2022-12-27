package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;

import java.util.List;

public interface BankOfficeService {
    // Создать офис
    BankOffice create(BankOffice bankOffice);

    // Добавить офис
    BankOffice addOffice(BankOffice office);

    // Получить все офисы
    List<BankOffice> getAllOffices();

    // Получить офис по айди
    BankOffice getOfficeById(String officeId);

    // Получить все офисы банка
    List<BankOffice> getOfficesByBankId(String bankId);

    // Удалить офис банка
    Boolean deleteOffice(String officeId);

    // Добавить банкомат в офис
    Boolean addAtm(String officeId, BankAtm bankAtm);

    // Удалить банкомат из офиса
    Boolean removeAtm(String officeId, String atmId);

    // Добавить сотрудника
    Boolean addEmployee(String officeId, Employee employee);

    // Удалить сотрудника
    Boolean removeEmployee(String officeId, String employeeId);

    // Внести деньги в офис
    void depositMoney(String bankOfficeId, double sum);

    // Снять деньги из офис
    void withdrawMoney(String bankOfficeId, double sum);

    String stringRepresentation(String officeId);
}
