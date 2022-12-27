package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.Address;

import java.util.Objects;

final public class BankOffice {
    //region ===================== Properties ======================
    private String id;
    private String name;
    private String address;
    private Boolean isOpen;
    private Boolean isAtmPlacementAvailable;
    private Bank bank;
    private int atmsCount;
    private int employeesCount;
    private Boolean isApplyingForLoansAvailable;
    private Boolean isCashWithdrawalAvailable;
    private Boolean isCashDepositAvailable;
    private double totalCash;
    private int rentPrice;

    //region ===================== Constructors ======================
    public BankOffice(
            String id,
            String name,
            String address,
            Boolean isOpen,
            Boolean isAtmPlacementAvailable,
            Bank bank,
            int atmsCount,
            int employeesCount, Boolean isApplyingForLoansAvailable,
            Boolean isCashWithdrawalAvailable,
            Boolean isCashDepositAvailable,
            double totalCash,
            int rentPrice
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isOpen = isOpen;
        this.isAtmPlacementAvailable = isAtmPlacementAvailable;
        this.bank = bank;
        this.atmsCount = atmsCount;
        this.employeesCount = employeesCount;
        this.isApplyingForLoansAvailable = isApplyingForLoansAvailable;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalCash = totalCash;
        this.rentPrice = rentPrice;
    }

    public BankOffice(BankOffice bankOffice) {
        this.id = bankOffice.getId();
        this.name = bankOffice.getName();
        this.address = bankOffice.getAddress();
        this.isOpen = bankOffice.getOpen();
        this.isAtmPlacementAvailable = bankOffice.getAtmPlacementAvailable();
        this.bank = bankOffice.getBank();
        this.atmsCount = bankOffice.getAtmsCount();
        this.isApplyingForLoansAvailable = bankOffice.getApplyingForLoansAvailable();
        this.isCashWithdrawalAvailable = bankOffice.getCashWithdrawalAvailable();
        this.isCashDepositAvailable = bankOffice.getCashDepositAvailable();
        this.totalCash = bankOffice.getTotalCash();
        this.rentPrice = bankOffice.getRentPrice();
        this.employeesCount = bankOffice.getEmployeesCount();
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public void setAtmPlacementAvailable(Boolean atmPlacementAvailable) {
        isAtmPlacementAvailable = atmPlacementAvailable;
    }

    public void setBank(Bank bank) { this.bank = bank; }

    public void setAtmsCount(int atmsCount) {
        this.atmsCount = atmsCount;
    }

    public void setEmployeesCount(int employeesCount) { this.employeesCount = employeesCount; }

    public void setApplyingForLoansAvailable(Boolean applyingForLoansAvailable) {
        isApplyingForLoansAvailable = applyingForLoansAvailable;
    }

    public void setCashWithdrawalAvailable(Boolean cashWithdrawalAvailable) {
        isCashWithdrawalAvailable = cashWithdrawalAvailable;
    }

    public void setCashDepositAvailable(Boolean cashDepositAvailable) {
        isCashDepositAvailable = cashDepositAvailable;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public Boolean getAtmPlacementAvailable() {
        return isAtmPlacementAvailable;
    }

    public Bank getBank() { return this.bank; }

    public int getAtmsCount() {
        return atmsCount;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public Boolean getApplyingForLoansAvailable() {
        return isApplyingForLoansAvailable;
    }

    public Boolean getCashWithdrawalAvailable() {
        return isCashWithdrawalAvailable;
    }

    public Boolean getCashDepositAvailable() {
        return isCashDepositAvailable;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankOffice that = (BankOffice) o;
        return getId().equals(that.getId()) && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "BankOffice{" + "\n" +
                "id='" + id + "\n" +
                "name='" + name + "\n" +
                "address=" + address + "\n" +
                "bank=" + bank.getName() + "\n" +
                "isOpen=" + isOpen + "\n" +
                "isAtmPlacementAvailable=" + isAtmPlacementAvailable + "\n" +
                "atmsCount=" + atmsCount + "\n" +
                "employeesCount" + employeesCount + "\n" +
                "isApplyingForLoansAvailable=" + isApplyingForLoansAvailable + "\n" +
                "isCashWithdrawalAvailable=" + isCashWithdrawalAvailable + "\n" +
                "isCashDepositAvailable=" + isCashDepositAvailable + "\n" +
                "totalCash=" + totalCash + "\n" +
                "rentPrice=" + rentPrice + "\n" +
                '}'+ "\n";
    }
}
