package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.PaymentAccount;
import tech.reliab.course.anisimov.service.PaymentAccountService;

final public class PaymentAccountServiceImpl implements PaymentAccountService {
    //region ===================== Properties ======================
    private PaymentAccount paymentAccount = null;

    //region ===================== PaymentService implementation ======================
    @Override
    public PaymentAccount create(PaymentAccount paymentAccount) {
        return null;
    }

    @Override
    public void depositMoney(PaymentAccount account, double sum) {

    }

    @Override
    public void withdrawMoney(PaymentAccount account, double sum) {

    }
}
