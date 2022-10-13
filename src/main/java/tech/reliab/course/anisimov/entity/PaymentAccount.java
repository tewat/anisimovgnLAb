package tech.reliab.course.anisimov.entity;

import java.util.Objects;

final public class PaymentAccount {
    //region ===================== Properties ======================
    private String id;
    private String userId;
    private String bankName;
    private int totalCash;

    //region ===================== Constructors ======================
    public PaymentAccount(String id, String userId, String bankName, int totalCash) {
        this.id = id;
        this.userId = userId;
        this.bankName = bankName;
        this.totalCash = totalCash;
    }

    public PaymentAccount(String id, String userId, String bankName) {
        this.id = id;
        this.userId = userId;
        this.bankName = bankName;
        this.totalCash = 0;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserId() {
        return userId;
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
        return getId().equals(that.getId()) && getUserId().equals(that.getUserId()) && getBankName().equals(that.getBankName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getBankName());
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", bankName='" + bankName + '\'' +
                ", totalCash=" + totalCash +
                '}';
    }
}
