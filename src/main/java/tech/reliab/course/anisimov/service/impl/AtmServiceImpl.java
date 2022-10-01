package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.service.AtmService;

final public class AtmServiceImpl implements AtmService {
    //region ===================== Properties ======================
    private BankAtm bankAtm = null;

    //region ===================== AtmService implementation ======================
    @Override
    public BankAtm getAtm() {
        return bankAtm;
    }

    @Override
    public void setAtm(BankAtm atm) {
        bankAtm = atm;
    }

    @Override
    public Boolean updateAtm(BankAtm atm) {
        if (bankAtm == atm) {
            setAtm(atm);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteAtm(BankAtm atm) {
        if (bankAtm == atm) {
            bankAtm = null;
            return true;
        } else {
            return false;
        }
    }
}
