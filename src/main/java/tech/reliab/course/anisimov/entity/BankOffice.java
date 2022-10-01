package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.Address;

import java.util.Objects;

public class BankOffice {
    //region ===================== Properties ======================
    private String id;
    private String name;
    private Address address;
    private Boolean isOpen;
    private Boolean isAtmPlacementAvailable;
    private int atmsCount;
    private Boolean isApplyingForLoansAvailable;
    private Boolean isCashWithdrawalAvailable;
    private Boolean isCashDepositAvailable;
    private int totalCash;
    private int rentPrice;

    //region ===================== Constructors ======================
    public BankOffice(
            String id,
            String name,
            Address address,
            Boolean isOpen,
            Boolean isAtmPlacementAvailable,
            int atmsCount,
            Boolean isApplyingForLoansAvailable,
            Boolean isCashWithdrawalAvailable,
            Boolean isCashDepositAvailable,
            int totalCash,
            int rentPrice
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isOpen = isOpen;
        this.isAtmPlacementAvailable = isAtmPlacementAvailable;
        this.atmsCount = atmsCount;
        this.isApplyingForLoansAvailable = isApplyingForLoansAvailable;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalCash = totalCash;
        this.rentPrice = rentPrice;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public void setAtmPlacementAvailable(Boolean atmPlacementAvailable) {
        isAtmPlacementAvailable = atmPlacementAvailable;
    }

    public void setAtmsCount(int atmsCount) {
        this.atmsCount = atmsCount;
    }

    public void setApplyingForLoansAvailable(Boolean applyingForLoansAvailable) {
        isApplyingForLoansAvailable = applyingForLoansAvailable;
    }

    public void setCashWithdrawalAvailable(Boolean cashWithdrawalAvailable) {
        isCashWithdrawalAvailable = cashWithdrawalAvailable;
    }

    public void setCashDepositAvailable(Boolean cashDepositAvailable) {
        isCashDepositAvailable = cashDepositAvailable;
    }

    public void setTotalCash(int totalCash) {
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

    public Address getAddress() {
        return address;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public Boolean getAtmPlacementAvailable() {
        return isAtmPlacementAvailable;
    }

    public int getAtmsCount() {
        return atmsCount;
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

    public int getTotalCash() {
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
        return "BankOffice{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", isOpen=" + isOpen +
                ", isAtmPlacementAvailable=" + isAtmPlacementAvailable +
                ", atmsCount=" + atmsCount +
                ", isApplyingForLoansAvailable=" + isApplyingForLoansAvailable +
                ", isCashWithdrawalAvailable=" + isCashWithdrawalAvailable +
                ", isCashDepositAvailable=" + isCashDepositAvailable +
                ", totalCash=" + totalCash +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
