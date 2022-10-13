package tech.reliab.course.anisimov.entity;

import java.util.Date;
import java.util.Objects;

final public class CreditAccount {
    //region ===================== Properties ======================
    private String id;
    private String customerId;
    private String bankName;
    private Date loanStartDate;
    private Date loadEndDate;
    private int loanMonthCount;
    private int loanAmount;
    private int monthlyPayment;
    private int interestRate;
    private String employeeId;
    private String paymentAccountId;

    //region ===================== Constructors ======================
    public CreditAccount(
            String id,
            String customerId,
            String bankName,
            Date loanStartDate,
            Date loadEndDate,
            int loanMonthCount,
            int loanAmount,
            int monthlyPayment,
            int interestRate,
            String employeeId,
            String paymentAccountId
    ) {
        this.id = id;
        this.customerId = customerId;
        this.bankName = bankName;
        this.loanStartDate = loanStartDate;
        this.loadEndDate = loadEndDate;
        this.loanMonthCount = loanMonthCount;
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.employeeId = employeeId;
        this.paymentAccountId = paymentAccountId;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public void setLoadEndDate(Date loadEndDate) {
        this.loadEndDate = loadEndDate;
    }

    public void setLoanMonthCount(int loanMonthCount) {
        this.loanMonthCount = loanMonthCount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setPaymentAccountId(String paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBankName() {
        return bankName;
    }

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public Date getLoadEndDate() {
        return loadEndDate;
    }

    public int getLoanMonthCount() {
        return loanMonthCount;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPaymentAccountId() {
        return paymentAccountId;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAccount that = (CreditAccount) o;
        return getId().equals(that.getId()) && getCustomerId().equals(that.getCustomerId()) && getBankName().equals(that.getBankName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getBankName());
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id='" + id + '\'' +
                ", customerId=" + customerId +
                ", bankName='" + bankName + '\'' +
                ", loanStartDate=" + loanStartDate +
                ", loadEndDate=" + loadEndDate +
                ", loanMonthCount=" + loanMonthCount +
                ", loanAmount=" + loanAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employeeId=" + employeeId +
                ", paymentAccountId=" + paymentAccountId +
                '}';
    }
}
