package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.BankOffice;

public interface BankOfficeService {
    BankOffice getOffice();

    void setOffice(BankOffice office);

    Boolean updateOffice(BankOffice office);

    Boolean deleteOffice(BankOffice office);
}
