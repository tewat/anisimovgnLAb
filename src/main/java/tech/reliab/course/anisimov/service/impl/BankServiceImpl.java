package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.service.BankService;

final public class BankServiceImpl implements BankService {
    //region ===================== Properties ======================
    private Bank bank = null;

    //region ===================== BankService implementation ======================
    @Override
    public Bank getBank() {
        return bank;
    }

    @Override
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Boolean updateBank(Bank bank) {
        if (this.bank == bank) {
            setBank(bank);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteBank(Bank bank) {
        if (this.bank == bank) {
            this.bank = null;
            return true;
        } else {
            return false;
        }
    }
}
