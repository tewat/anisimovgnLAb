package tech.reliab.course.anisimov.entity;

import java.util.Objects;

final public class PaymentAccount {
    //region ===================== Properties ======================
    private String id;
    private User user;
    private Bank bank;
    private double totalCash;

    //region ===================== Constructors ======================
    public PaymentAccount(String id, User user, Bank bank, double totalCash) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.totalCash = totalCash;
    }

    public PaymentAccount(String id, User user, Bank bank) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.totalCash = 0;
    }

    public PaymentAccount(PaymentAccount account) {
        this.id = account.id;
        this.user = account.user;
        this.bank = account.bank;
        this.totalCash = account.totalCash;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public double getTotalCash() {
        return totalCash;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentAccount that = (PaymentAccount) o;
        return getId().equals(that.getId()) &&
                getUser().getId().equals(that.getUser().getId()) &&
                getBank().getId().equals(that.getBank().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser().getId(), getBank().getId());
    }

    @Override
    public String toString() {
        return "PaymentAccount{" + "\n" +
                "id='" + id + "\n" +
                "userName=" + user.getFullName() + "\n" +
                "bankName='" + bank.getName() + "\n" +
                "totalCash=" + totalCash + "\n" +
                '}' + "\n";
    }
}
