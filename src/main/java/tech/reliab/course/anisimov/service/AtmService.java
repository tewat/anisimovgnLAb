package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankAtm;

import java.util.List;

public interface AtmService {
    // Создать банкомат
    BankAtm create(BankAtm bankAtm);

    // Добавить банкомат
    BankAtm addAtm(BankAtm bankAtm);

    // Получить банкомат по айди
    BankAtm getAtmById(String atmId);

    // Получить все бакнкоматы банка
    List<BankAtm> getAllAtms(String bankId);

    // Получить все банкоматы офисы
    List<BankAtm> getAtmsByOfficeId(String officeId);

    // Получить вс банкоматы банка
    List<BankAtm> getAtmsByBankId(String bankId);

    // Удалить банкомат
    Boolean deleteAtm(String atmId);

    // Внести деньги
    void depositMoney(String atmId, double sum);

    void withdrawMoney(String atmId, double sum);

    String stringRepresentation(String atmId);
}
