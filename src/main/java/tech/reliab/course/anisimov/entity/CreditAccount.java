package tech.reliab.course.anisimov.entity;

import java.util.Date;
import java.util.Objects;

public class CreditAccount {
    //region ===================== Properties ======================
    private String id;
    private User customer;
    private String bankName;
    private Date loanStartDate;
    private Date loadEndDate;
    private int loanMonthCount;
    private int loanAmount;
    private int monthlyPayment;
    private int interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    //region ===================== Constructors ======================
    public CreditAccount(
            String id,
            User customer,
            String bankName,
            Date loanStartDate,
            Date loadEndDate,
            int loanMonthCount,
            int loanAmount,
            int monthlyPayment,
            int interestRate,
            Employee employee,
            PaymentAccount paymentAccount
    ) {
        this.id = id;
        this.customer = customer;
        this.bankName = bankName;
        this.loanStartDate = loanStartDate;
        this.loadEndDate = loadEndDate;
        this.loanMonthCount = loanMonthCount;
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
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

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public User getCustomer() {
        return customer;
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

    public Employee getEmployee() {
        return employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAccount that = (CreditAccount) o;
        return getId().equals(that.getId()) && getCustomer().equals(that.getCustomer()) && getBankName().equals(that.getBankName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getBankName());
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", bankName='" + bankName + '\'' +
                ", loanStartDate=" + loanStartDate +
                ", loadEndDate=" + loadEndDate +
                ", loanMonthCount=" + loanMonthCount +
                ", loanAmount=" + loanAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employee=" + employee +
                ", paymentAccount=" + paymentAccount +
                '}';
    }
}
