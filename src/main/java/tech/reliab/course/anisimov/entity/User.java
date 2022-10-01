package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.FullName;

import java.util.Date;
import java.util.Objects;
import java.util.random.RandomGenerator;

final public class User {
    //region ===================== Properties ======================
    private String id;
    private FullName fullName;
    private Date birthDate;
    private String placeOfWork;
    private int monthlyIncome;
    // TODO: Change to lists when allowed
    private Bank banks;
    private CreditAccount creditAccounts;
    private PaymentAccount paymentAccounts;
    private int loanRating;

    //region ===================== Constructors ======================
    public User(
            String id,
            FullName fullName,
            Date birthDate,
            String placeOfWork,
            int monthlyIncome,
            Bank banks,
            CreditAccount creditAccounts,
            PaymentAccount paymentAccounts,
            int loanRating
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlyIncome = monthlyIncome;
        this.banks = banks;
        this.creditAccounts = creditAccounts;
        this.paymentAccounts = paymentAccounts;
        this.loanRating = loanRating;
    }

    public User(
            String id,
            FullName fullName,
            Date birthDate,
            String placeOfWork,
            Bank banks,
            CreditAccount creditAccounts,
            PaymentAccount paymentAccounts
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.banks = banks;
        this.creditAccounts = creditAccounts;
        this.paymentAccounts = paymentAccounts;

        this.monthlyIncome = RandomGenerator.getDefault().nextInt(100, 10_000);
        this.loanRating = RandomGenerator.getDefault().nextInt(this.monthlyIncome / 10, this.monthlyIncome);
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setBanks(Bank banks) {
        this.banks = banks;
    }

    public void setCreditAccounts(CreditAccount creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public void setPaymentAccounts(PaymentAccount paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public void setLoanRating(int loanRating) {
        this.loanRating = loanRating;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public Bank getBanks() {
        return banks;
    }

    public CreditAccount getCreditAccounts() {
        return creditAccounts;
    }

    public PaymentAccount getPaymentAccounts() {
        return paymentAccounts;
    }

    public int getLoanRating() {
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
                ", banks=" + banks +
                ", creditAccounts=" + creditAccounts +
                ", paymentAccounts=" + paymentAccounts +
                ", loanRating=" + loanRating +
                '}';
    }
}
