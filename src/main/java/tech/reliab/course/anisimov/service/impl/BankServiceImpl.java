package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.service.BankService;

public class BankServiceImpl implements BankService {
    //region ===================== Properties ======================
    private Bank _bank = null;

    //region ===================== BankService implementation ======================
    @Override
    public Bank getBank() {
        return _bank;
    }

    @Override
    public void setBank(Bank bank) {
        _bank = bank;
    }

    @Override
    public Boolean updateBank(Bank bank) {
        if (_bank == bank) {
            setBank(bank);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteBank(Bank bank) {
        if (_bank == bank) {
            _bank = null;
            return true;
        } else {
            return false;
        }
    }
}
