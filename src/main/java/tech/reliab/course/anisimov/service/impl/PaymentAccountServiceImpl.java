package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.PaymentAccount;
import tech.reliab.course.anisimov.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    //region ===================== Properties ======================
    private PaymentAccount paymentAccount = null;

    //region ===================== PaymentService implementation ======================
    @Override
    public PaymentAccount getAccount() {
        return paymentAccount;
    }

    @Override
    public void setAccount(PaymentAccount account) {
        this.paymentAccount = account;
    }

    @Override
    public Boolean updateAccount(PaymentAccount account) {
        if (paymentAccount == account) {
            setAccount(account);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteAccount(PaymentAccount account) {
        if (paymentAccount == account) {
            paymentAccount = null;
            return true;
        } else {
            return false;
        }
    }
}
