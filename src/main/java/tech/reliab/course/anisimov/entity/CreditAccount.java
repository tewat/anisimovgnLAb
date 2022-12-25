package tech.reliab.course.anisimov.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

final public class CreditAccount {
    //region ===================== Properties ======================
    private String id;
    private User customer;
    private Bank bank;
    private LocalDate loanStartDate;
    private LocalDate loadEndDate;
    private int loanMonthCount;
    private double loanAmount;
    private double monthlyPayment;
    private int interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    //region ===================== Constructors ======================
    public CreditAccount(
            String id,
            User customer,
            Bank bank,
            LocalDate loanStartDate,
            LocalDate loadEndDate,
            int loanMonthCount,
            Double loanAmount,
            Double monthlyPayment,
            int interestRate,
            Employee employee,
            PaymentAccount paymentAccount
    ) {
        this.id = id;
        this.customer = customer;
        this.bank = bank;
        this.loanStartDate = loanStartDate;
        this.loadEndDate = loadEndDate;
        this.loanMonthCount = loanMonthCount;
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(CreditAccount account) {
        this.id = account.id;
        this.customer = account.customer;
        this.bank = account.bank;
        this.loanStartDate = account.loanStartDate;
        this.loadEndDate = account.loadEndDate;
        this.loanMonthCount = account.loanMonthCount;
        this.loanAmount = account.loanAmount;
        this.monthlyPayment = account.monthlyPayment;
        this.interestRate = account.interestRate;
        this.employee = account.employee;
        this.paymentAccount = account.paymentAccount;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public void setLoadEndDate(LocalDate loadEndDate) {
        this.loadEndDate = loadEndDate;
    }

    public void setLoanMonthCount(int loanMonthCount) {
        this.loanMonthCount = loanMonthCount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setMonthlyPayment(double monthlyPayment) {
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

    public Bank getBank() {
        return bank;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public LocalDate getLoadEndDate() {
        return loadEndDate;
    }

    public int getLoanMonthCount() {
        return loanMonthCount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getMonthlyPayment() {
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
        return getId().equals(that.getId()) &&
                getCustomer().getId().equals(that.getCustomer().getId()) &&
                getBank().getId().equals(that.getBank().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer().getId(), getBank().getId());
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id='" + id + '\'' +
                ", customer=" + customer.getId() +
                ", bankName='" + bank.getName() + '\'' +
                ", loanStartDate=" + loanStartDate +
                ", loadEndDate=" + loadEndDate +
                ", loanMonthCount=" + loanMonthCount +
                ", loanAmount=" + loanAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employeeId=" + employee.getId() +
                ", paymentAccountId=" + paymentAccount.getId() +
                '}';
    }
}
