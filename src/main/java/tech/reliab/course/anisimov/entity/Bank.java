package tech.reliab.course.anisimov.entity;

import java.util.Objects;
import java.util.random.RandomGenerator;

final public class Bank {
    //region ===================== Properties ======================
    private String id;
    private String name;
    private int officesCount;
    private int atmsCount;
    private int employeesCount;
    private int clientsCount;
    private int rating;
    private int totalMoney;
    private double interestRate;

    //region ===================== Constructors ======================
    public Bank(
            String id,
            String name,
            int officesCount,
            int atmsCount,
            int employeesCount,
            int clientsCount,
            int rating,
            int totalMoney,
            double interestRate
    ) {
        this.id = id;
        this.name = name;
        this.officesCount = officesCount;
        this.atmsCount = atmsCount;
        this.employeesCount = employeesCount;
        this.clientsCount = clientsCount;
        this.rating = rating;
        this.totalMoney = totalMoney;
        this.interestRate = interestRate;
    }

    public Bank(String id, String name) {
        this.id = id;
        this.name = name;
        this.officesCount = 0;
        this.atmsCount = 0;
        this.employeesCount = 0;
        this.clientsCount = 0;
        this.rating = RandomGenerator.getDefault().nextInt(0, 100);
        this.totalMoney = RandomGenerator.getDefault().nextInt(0, 1_000_000);
        this.interestRate = RandomGenerator.getDefault().nextDouble(0.1, 20.0);
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficesCount(int officesCount) {
        this.officesCount = officesCount;
    }

    public void setAtmsCount(int atmsCount) {
        this.atmsCount = atmsCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public void setClientsCount(int clientsCount) {
        this.clientsCount = clientsCount;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOfficesCount() {
        return officesCount;
    }

    public int getAtmsCount() {
        return atmsCount;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }
    public int getClientsCount() {
        return clientsCount;
    }

    public int getRating() {
        return rating;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;
        return getId().equals(bank.getId()) && getName().equals(bank.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", officesCount=" + officesCount +
                ", atmsCount=" + atmsCount +
                ", employeesCount=" + employeesCount +
                ", clientsCount=" + clientsCount +
                ", rating=" + rating +
                ", totalMoney=" + totalMoney +
                ", interestRate=" + interestRate +
                '}';
    }
}
