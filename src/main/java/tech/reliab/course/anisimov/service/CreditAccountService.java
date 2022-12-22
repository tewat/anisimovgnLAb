package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.CreditAccount;

public interface CreditAccountService {
    // Создание кредитного аккаунта
    CreditAccount create(CreditAccount creditAccount);

    // Списать оплату за месяц
    void executeMonthlyPayment(CreditAccount creditAccount);
}
