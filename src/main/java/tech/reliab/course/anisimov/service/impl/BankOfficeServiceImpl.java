package tech.reliab.course.anisimov.service.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;
import tech.reliab.course.anisimov.service.AtmService;
import tech.reliab.course.anisimov.service.BankOfficeService;
import tech.reliab.course.anisimov.service.BankService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final public class BankOfficeServiceImpl implements BankOfficeService {
    //region ===================== Properties ======================
    private final Map<String, BankOffice> bankOfficeMap= new HashMap<>();

    //region ===================== DI ======================
    @NotNull public BankService bankService;
    @NotNull public AtmService atmService;

    //region ===================== Constructor ======================
    public BankOfficeServiceImpl() { }

    //region ===================== BankOfficeService implementation ======================
    @Override
    public @Nullable BankOffice create(@NotNull BankOffice bankOffice) {
        return this.addOffice(bankOffice);
    }

    @Override
    public @Nullable BankOffice addOffice(BankOffice office) {
        if (this.bankOfficeMap.containsKey(office.getId())) {
            System.out.println("Офис с таким айди уже существует в системе");
            return null;
        }

        Bank bank = office.getBank();
        if (bank != null) {
            this.bankOfficeMap.put(office.getId(), office);
            this.bankService.addOffice(bank.getId(), office);
            return office;
        } else {
            System.out.println("У офиса не указан банк");
            return null;
        }
    }

    @Override
    public @Nullable BankOffice getOfficeById(@NotNull String officeId) {
        return this.bankOfficeMap.get(officeId);
    }

    @Override
    public @NotNull List<BankOffice> getOfficesByBankId(@NotNull String bankId) {
        return this.bankOfficeMap.values()
                .stream()
                .filter(bankOffice -> Objects.equals(bankOffice.getBank().getId(), bankId))
                .toList();
    }

    @Override
    public @NotNull Boolean deleteOffice(@NotNull String officeId) {
        BankOffice office = this.bankOfficeMap.get(officeId);
        if (office == null) { return false; }

        this.atmService.getAtmsByOfficeId(officeId).forEach(bankAtm -> this.removeAtm(officeId, bankAtm.getId()));
        this.bankService.removeOffice(office.getBank().getId(), officeId);

        return true;
    }

    @Override
    public @NotNull Boolean addAtm(@NotNull String officeId, @NotNull BankAtm bankAtm) {
        BankOffice office = this.getOfficeById(officeId);
        if (office == null || office.getBank() == null) { return false; }

        if (office.getAtmPlacementAvailable()) {
            office.setAtmsCount(office.getAtmsCount() + 1);
            office.getBank().setAtmsCount(office.getBank().getAtmsCount() + 1);

            bankAtm.setBankOffice(office);
            bankAtm.setParentBank(office.getBank());

            this.depositMoney(officeId, bankAtm.getTotalCash());

            return true;
        } else {
            System.out.println("Нет возможности уставновить банкомат");
            return false;
        }
    }

    @Override
    public @NotNull Boolean removeAtm(@NotNull String officeId, @NotNull String atmId) {
        BankOffice office = this.getOfficeById(officeId);
        BankAtm atm = this.atmService.getAtmById(atmId);
        if (office == null || office.getBank() == null || atm == null) { return false; }

        double sum = atm.getTotalCash();
        if (this.atmService.deleteAtm(atmId) != null) {
            office.setAtmsCount(office.getAtmsCount() - 1);
            office.getBank().setAtmsCount(office.getBank().getAtmsCount() - 1);

            this.withdrawMoney(officeId, sum);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public @NotNull Boolean addEmployee(@NotNull String officeId, @NotNull Employee employee) {
        BankOffice office = this.getOfficeById(officeId);
        if (office == null) { return false; }

        employee.setOffice(office);
        employee.setBankOfWork(office.getBank());

        if (this.bankService.addEmployee(employee.getBankOfWork().getId(), employee)) {
            office.setEmployeesCount(office.getEmployeesCount() + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean removeEmployee(String officeId, String employeeId) {
        BankOffice office = this.getOfficeById(officeId);
        if (office == null || office.getBank() == null) { return false; }

        return this.bankService.removeEmployee(office.getBank().getId(), employeeId);
    }

    @Override
    public void depositMoney(String bankOfficeId, double sum) {
        BankOffice office = this.getOfficeById(bankOfficeId);
        if (office == null || office.getBank() == null) { return; }

        if (office.getCashDepositAvailable()) {
            office.setTotalCash(office.getTotalCash() + sum);
            this.bankService.depositMoney(office.getBank().getId(), sum);
        } else {
            System.out.println("В данном офисе нельзя вносить наличные");
        }
    }

    @Override
    public void withdrawMoney(String bankOfficeId, double sum) {
        BankOffice office = this.getOfficeById(bankOfficeId);
        if (office == null || office.getBank() == null) { return; }

        if (office.getCashWithdrawalAvailable()) {
            if (office.getTotalCash() < sum) {
                office.setTotalCash(office.getTotalCash() - sum);
                this.bankService.withdrawMoney(office.getBank().getId(), sum);
            } else {
                System.out.println("В офисе недостаточно средств");
            }
        } else {
            System.out.println("В данном офисе нельзя снимать наличные");
        }
    }
}
