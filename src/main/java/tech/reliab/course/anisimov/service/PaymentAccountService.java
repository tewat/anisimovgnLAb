package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.PaymentAccount;

public interface PaymentAccountService {
    // Создание платежного аккаунта
    PaymentAccount create(PaymentAccount paymentAccount);

    // Внести деньги
    void depositMoney(PaymentAccount account, double sum);

    // Снять деньги
    void withdrawMoney(PaymentAccount account, double sum);
}
