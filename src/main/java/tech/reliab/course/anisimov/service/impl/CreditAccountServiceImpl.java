package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.CreditAccount;
import tech.reliab.course.anisimov.service.CreditAccountService;

final public class CreditAccountServiceImpl implements CreditAccountService {
    //region ===================== Properties ======================
    private CreditAccount creditAccount= null;

    //region ===================== CreditAccountService implementation ======================
    @Override
    public CreditAccount getAccount() {
        return creditAccount;
    }

    @Override
    public void setAccount(CreditAccount account) {
        creditAccount = account;
    }

    @Override
    public Boolean updateAccount(CreditAccount account) {
        if (creditAccount == account) {
            setAccount(creditAccount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteAccount(CreditAccount account) {
        if (creditAccount == account) {
            creditAccount = null;
            return true;
        } else {
            return false;
        }
    }
}
