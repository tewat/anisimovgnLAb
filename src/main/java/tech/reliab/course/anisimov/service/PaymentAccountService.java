package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.PaymentAccount;

public interface PaymentAccountService {
    PaymentAccount getAccount();

    void setAccount(PaymentAccount account);

    Boolean updateAccount(PaymentAccount account);

    Boolean deleteAccount(PaymentAccount account);
}
