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
    private String banksIds;
    private String creditAccountsIds;
    private String paymentAccountsIds;
    private int loanRating;

    //region ===================== Constructors ======================
    public User(
            String id,
            FullName fullName,
            Date birthDate,
            String placeOfWork,
            int monthlyIncome,
            String banksIds,
            String creditAccountsIds,
            String paymentAccountsIds,
            int loanRating
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlyIncome = monthlyIncome;
        this.banksIds = banksIds;
        this.creditAccountsIds = creditAccountsIds;
        this.paymentAccountsIds = paymentAccountsIds;
        this.loanRating = loanRating;
    }

    public User(
            String id,
            FullName fullName,
            Date birthDate,
            String placeOfWork,
            String banksIds,
            String creditAccountsIds,
            String paymentAccountsIds
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.banksIds = banksIds;
        this.creditAccountsIds = creditAccountsIds;
        this.paymentAccountsIds = paymentAccountsIds;

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

    public void setBanksIds(String banksIds) {
        this.banksIds = banksIds;
    }

    public void setCreditAccountsIds(String creditAccountsIds) {
        this.creditAccountsIds = creditAccountsIds;
    }

    public void setPaymentAccountsIds(String paymentAccountsIds) {
        this.paymentAccountsIds = paymentAccountsIds;
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

    public String getBanksIds() {
        return banksIds;
    }

    public String getCreditAccountsIds() {
        return creditAccountsIds;
    }

    public String getPaymentAccountsIds() {
        return paymentAccountsIds;
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
                ", banksIds=" + banksIds +
                ", creditAccountId=" + creditAccountsIds +
                ", paymentAccountId=" + paymentAccountsIds +
                ", loanRating=" + loanRating +
                '}';
    }
}
