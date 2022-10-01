package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.Address;

import java.util.Objects;

public class BankAtm {
    //region ===================== Properties ======================
    String id;
    String name;
    Address bankOfficeAddress;
    Boolean isOpen;
    Bank parentBank;
    String placementInBank;
    Employee maintenanceEmployee;
    Boolean isCashWithdrawalAvailable;
    Boolean isCashDepositAvailable;
    int totalCash;
    int costService;

    //region ===================== Constructors ======================
    public BankAtm(
            String id,
            String name,
            Address bankOfficeAddress,
            Boolean isOpen,
            Bank parentBank,
            String placementInBank,
            Employee maintenanceEmployee,
            Boolean isCashWithdrawalAvailable,
            Boolean isCashDepositAvailable,
            int totalCash,
            int costService
    ) {
        this.id = id;
        this.name = name;
        this.bankOfficeAddress = bankOfficeAddress;
        this.isOpen = isOpen;
        this.parentBank = parentBank;
        this.placementInBank = placementInBank;
        this.maintenanceEmployee = maintenanceEmployee;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalCash = totalCash;
        this.costService = costService;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankOfficeAddress(Address bankOfficeAddress) {
        this.bankOfficeAddress = bankOfficeAddress;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public void setParentBank(Bank parentBank) {
        this.parentBank = parentBank;
    }

    public void setPlacementInBank(String placementInBank) {
        this.placementInBank = placementInBank;
    }

    public void setMaintenanceEmployee(Employee maintenanceEmployee) {
        this.maintenanceEmployee = maintenanceEmployee;
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

    public void setCostService(int costService) {
        this.costService = costService;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getBankOfficeAddress() {
        return bankOfficeAddress;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public Bank getParentBank() {
        return parentBank;
    }

    public String getPlacementInBank() {
        return placementInBank;
    }

    public Employee getMaintenanceEmployee() {
        return maintenanceEmployee;
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

    public int getCostService() {
        return costService;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAtm bankAtm = (BankAtm) o;
        return getId().equals(bankAtm.getId()) && getName().equals(bankAtm.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bankOfficeAddress=" + bankOfficeAddress +
                ", isOpen=" + isOpen +
                ", parentBank=" + parentBank +
                ", placementInBank='" + placementInBank + '\'' +
                ", maintenanceEmployee=" + maintenanceEmployee +
                ", isCashWithdrawalAvailable=" + isCashWithdrawalAvailable +
                ", isCashDepositAvailable=" + isCashDepositAvailable +
                ", totalCash=" + totalCash +
                ", costService=" + costService +
                '}';
    }
}
