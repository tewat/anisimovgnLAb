package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.CreditAccount;

public interface CreditAccountService {
    CreditAccount getAccount();

    void setAccount(CreditAccount account);

    Boolean updateAccount(CreditAccount account);

    Boolean deleteAccount(CreditAccount account);
}
