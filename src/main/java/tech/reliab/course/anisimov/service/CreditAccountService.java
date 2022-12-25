package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.CreditAccount;

import java.util.List;

public interface CreditAccountService {
    // Создание кредитного аккаунта
    CreditAccount create(CreditAccount creditAccount);

    // Добавить кредитный аккаунт
    CreditAccount addAccount(CreditAccount account);

    // Удалить делитный аккаунт
    Boolean deleteAccount(String accountId);

    // Получить кредтиный аккаунты пользователя
    List<CreditAccount> getUsersAccounts(String userId);

    // Списать оплату за месяц
    void executeMonthlyPayment(CreditAccount creditAccount);
}
