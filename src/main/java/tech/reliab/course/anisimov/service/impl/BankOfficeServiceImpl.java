package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    //region ===================== Properties ======================
    private BankOffice bankOffice = null;

    //region ===================== BankOfficeService implementation ======================
    @Override
    public BankOffice getOffice() {
        return bankOffice;
    }

    @Override
    public void setOffice(BankOffice office) {
        bankOffice = office;
    }

    @Override
    public Boolean updateOffice(BankOffice office) {
        if (bankOffice == bankOffice) {
            setOffice(office);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteOffice(BankOffice office) {
        if (bankOffice == office) {
            bankOffice = null;
            return true;
        } else {
            return false;
        }
    }
}
