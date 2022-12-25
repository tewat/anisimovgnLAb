package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.PaymentAccount;

import java.util.List;

public interface PaymentAccountService {
    // Создание платежного аккаунта
    PaymentAccount create(PaymentAccount paymentAccount);

    // Добавление платежного аккаунта
    PaymentAccount addAccount(PaymentAccount account);

    // Удаление аккаунты
    Boolean deleteAccount(String accountId);

    // Получение аккаунта по айди
    PaymentAccount getAccountById(String accountId);

    // Получение всех аккаунтов польщователя
    List<PaymentAccount> getUsersAccounts(String userId);

    // Внести деньги
    void depositMoney(PaymentAccount account, double sum);

    // Снять деньги
    void withdrawMoney(PaymentAccount account, double sum);
}
