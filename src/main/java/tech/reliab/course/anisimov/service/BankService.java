package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.Bank;

public interface BankService {
    Bank getBank();

    void setBank(Bank bank);

    Boolean updateBank(Bank bank);

    Boolean deleteBank(Bank bank);
}
