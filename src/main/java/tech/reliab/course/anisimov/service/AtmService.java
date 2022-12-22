package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankAtm;

public interface AtmService {
    BankAtm create(BankAtm bankAtm);

    void depositMoney(BankAtm bankAtm, double sum);

    void withdrawMoney(BankAtm bankAtm, double sum);
}
