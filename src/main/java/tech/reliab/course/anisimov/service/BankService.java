package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.*;

public interface BankService {
    // Создание банка
    Bank create(Bank bank);

    // Вычисление процентной ставки
    void calculateInterestRate(Bank bank);

    // Внести деньги
    void depositMoney(Bank bank, double sum);

    // Снять деньги
    void withdrawMoney(Bank bank, double sum);

    // Добавить офис
    void addOffice(Bank bank, BankOffice office);

    // Удалить офис
    void removeOffice(Bank bank, BankOffice office);

    // Добавить новго клиента
    void addClient(Bank bank, User user);

    // Удаление клиента
    void removeClient(Bank bank, User user);

    // Добавить работника
    void addEmployee(Bank bank, Employee employee);

    // Удалить работника
    void removeEmployee(Bank bank, Employee employee);

    // Одобрение кредита
    boolean isCreditAllowed(Bank bank, CreditAccount creditAccount, Employee employee);
}
