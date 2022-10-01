package tech.reliab.course.anisimov.entity;

import java.util.Objects;

public class PaymentAccount {
    //region ===================== Properties ======================
    private String id;
    private User user;
    private String bankName;
    private int totalCash;

    //region ===================== Constructors ======================
    public PaymentAccount(String id, User user, String bankName, int totalCash) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.totalCash = totalCash;
    }

    public PaymentAccount(String id, User user, String bankName) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.totalCash = 0;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getBankName() {
        return bankName;
    }

    public int getTotalCash() {
        return totalCash;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentAccount that = (PaymentAccount) o;
        return getId().equals(that.getId()) && getUser().equals(that.getUser()) && getBankName().equals(that.getBankName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getBankName());
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", totalCash=" + totalCash +
                '}';
    }
}
