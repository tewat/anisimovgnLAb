package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.FullName;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.random.RandomGenerator;

final public class User {
    //region ===================== Properties ======================
    private String id;
    private FullName fullName;
    private LocalDate birthDate;
    private String placeOfWork;
    private double monthlyIncome;
    private Bank bank;
    private int creditAccountsCount;
    private int paymentAccountCount;
    private double loanRating;

    //region ===================== Constructors ======================
    public User(
            String id,
            FullName fullName,
            LocalDate birthDate,
            String placeOfWork,
            double monthlyIncome,
            Bank bank,
            int creditAccountsCount,
            int paymentAccountsCount,
            double loanRating
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditAccountsCount = creditAccountsCount;
        this.paymentAccountCount = paymentAccountsCount;
        this.loanRating = loanRating;
    }

    public User(
            String id,
            FullName fullName,
            LocalDate birthDate,
            String placeOfWork,
            Bank bank,
            int creditAccountsCount,
            int paymentAccountCount
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.bank = bank;
        this.creditAccountsCount = creditAccountsCount;
        this.paymentAccountCount = paymentAccountCount;

        this.monthlyIncome = RandomGenerator.getDefault().nextInt(100, 10_000);
        this.loanRating = RandomGenerator.getDefault().nextDouble(this.monthlyIncome / 10.0, this.monthlyIncome);
    }

    public User(User user) {
        this.id = user.id;
        this.fullName = user.fullName;
        this.birthDate = user.birthDate;
        this.placeOfWork = user.placeOfWork;
        this.monthlyIncome = user.monthlyIncome;
        this.bank = user.bank;
        this.creditAccountsCount = user.creditAccountsCount;
        this.paymentAccountCount = user.paymentAccountCount;
        this.loanRating = user.loanRating;
    }
    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setCreditAccountsCount(int creditAccountsCount) {
        this.creditAccountsCount = creditAccountsCount;
    }

    public void setPaymentAccountsCount(int paymentAccountCount) {
        this.paymentAccountCount = paymentAccountCount;
    }

    public void setLoanRating(double loanRating) {
        this.loanRating = loanRating;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public Bank getBank() {
        return bank;
    }

    public int getCreditAccountsCount() {
        return creditAccountsCount;
    }

    public int getPaymentAccountsCount() {
        return paymentAccountCount;
    }

    public double getLoanRating() {
        return loanRating;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullName=" + fullName +
                ", birthDate=" + birthDate +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", banksIds=" + bank.getId() +
                ", creditAccountCount=" + creditAccountsCount +
                ", paymentAccountCount=" + paymentAccountCount +
                ", loanRating=" + loanRating +
                '}';
    }
}
