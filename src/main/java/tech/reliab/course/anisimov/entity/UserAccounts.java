package tech.reliab.course.anisimov.entity;

import java.util.List;

public class UserAccounts {
    //region ===================== Properties ======================
    private String userId;
    private List<PaymentAccount> paymentAccounts;
    private List<CreditAccount> creditAccounts;

    //region ===================== Constructors ======================
    public UserAccounts() {}

    public UserAccounts(String userId, List<PaymentAccount> paymentAccounts, List<CreditAccount> creditAccounts) {
        this.userId = userId;
        this.paymentAccounts = paymentAccounts;
        this.creditAccounts = creditAccounts;
    }

    //region ===================== Getters ======================
    public String getUserId() {
        return userId;
    }

    public List<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    //region ===================== Setters ======================
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public void setCreditAccounts(List<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }
}
