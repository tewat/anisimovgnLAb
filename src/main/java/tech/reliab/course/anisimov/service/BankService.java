package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.*;

import java.util.List;

public interface BankService {
    // Создание банка
    Bank create(Bank bank);

    // Добавление банка
    Bank addBank(Bank bank);

    // Получение банка по id
    Bank getBankById(String bankId);

    // Удалить банк по айди
    Boolean deleteBank(String bankId);

    // Получить все банки
    List<Bank> getAllBanks();

    // Вычисление процентной ставки
    void calculateInterestRate(String bankId);

    // Внести деньги
    void depositMoney(String bankId, double sum);

    // Снять деньги
    void withdrawMoney(String bankId, double sum);

    // Добавить офис
    void addOffice(String bankId, BankOffice office);

    // Удалить офис
    Boolean removeOffice(String bankId, String officeId);

    // Добавить новго клиента
    Boolean addClient(String bankId, User user);

    // Удаление клиента
    Boolean removeClient(String bankId, String userId);

    // Добавить работника
    Boolean addEmployee(String bankId, Employee employee);

    // Удалить работника
    Boolean removeEmployee(String bankId, String employeeId);

    // Одобрение кредита
    boolean isCreditAllowed(String bankId, CreditAccount creditAccount, Employee employee);
}
