package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.OpenStatus;

import java.util.Objects;

final public class BankAtm {
    //region ===================== Properties ======================
    private String id;
    private String name;
    private BankOffice bankOffice;
    private OpenStatus status;
    private Boolean isOpen;
    private Bank bank;
    private String placementInBank;
    private Employee maintenanceEmployee;
    private Boolean isCashWithdrawalAvailable;
    private Boolean isCashDepositAvailable;
    private double totalCash;
    private int costService;

    //region ===================== Constructors ======================
    public BankAtm(
            String id,
            String name,
            BankOffice bankOffice,
            OpenStatus status,
            Boolean isOpen,
            Bank bank,
            String placementInBank,
            Employee maintenanceEmployee,
            Boolean isCashWithdrawalAvailable,
            Boolean isCashDepositAvailable,
            double totalCash,
            int costService
    ) {
        this.id = id;
        this.name = name;
        this.bankOffice = bankOffice;
        this.status = status;
        this.isOpen = isOpen;
        this.bank = bank;
        this.placementInBank = placementInBank;
        this.maintenanceEmployee = maintenanceEmployee;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalCash = totalCash;
        this.costService = costService;
    }

    public BankAtm(BankAtm bankAtm) {
        this.id = bankAtm.getId();
        this.name = bankAtm.getName();
        this.bankOffice = bankAtm.bankOffice;
        this.status = bankAtm.getStatus();
        this.isOpen = bankAtm.getOpen();
        this.bank = bankAtm.getBank();
        this.placementInBank = bankAtm.getPlacementInBank();
        this.maintenanceEmployee = bankAtm.getMaintenanceEmployee();
        this.isCashWithdrawalAvailable = bankAtm.getCashWithdrawalAvailable();
        this.isCashDepositAvailable = bankAtm.getCashDepositAvailable();
        this.totalCash = bankAtm.getTotalCash();
        this.costService = bankAtm.getCostService();
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setStatus(OpenStatus status) { this.status = status; }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public void setParentBank(Bank bank) {
        this.bank = bank;
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

    public void setTotalCash(double totalCash) {
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

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public OpenStatus getStatus() { return this.status; }
    public Boolean getOpen() {
        return isOpen;
    }

    public Bank getBank() {
        return bank;
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

    public double getTotalCash() {
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
                ", bankOffice=" + bankOffice.getName() +
                ", status=" + status +
                ", isOpen=" + isOpen +
                ", parentBankId=" + bank +
                ", bank='" + bank.getName() + '\'' +
                ", maintenanceEmployee=" + maintenanceEmployee +
                ", isCashWithdrawalAvailable=" + isCashWithdrawalAvailable +
                ", isCashDepositAvailable=" + isCashDepositAvailable +
                ", totalCash=" + totalCash +
                ", costService=" + costService +
                '}';
    }
}
