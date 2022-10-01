package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankAtm;

public interface AtmService {
    BankAtm getAtm();

    void setAtm(BankAtm atm);

    Boolean updateAtm(BankAtm atm);

    Boolean deleteAtm(BankAtm atm);
}
