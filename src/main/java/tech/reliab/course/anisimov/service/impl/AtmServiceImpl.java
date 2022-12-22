package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.service.AtmService;

final public class AtmServiceImpl implements AtmService {
    //region ===================== Properties ======================
    private BankAtm bankAtm = null;

    //region ===================== AtmService implementation ======================
    @Override
    public BankAtm create(BankAtm bankAtm) {
        return null;
    }

    @Override
    public void depositMoney(BankAtm bankAtm, double sum) {

    }

    @Override
    public void withdrawMoney(BankAtm bankAtm, double sum) {

    }
}
