package tech.reliab.course.anisimov.service.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.reliab.course.anisimov.entity.*;
import tech.reliab.course.anisimov.service.BankOfficeService;
import tech.reliab.course.anisimov.service.BankService;

import java.util.*;
import java.util.random.RandomGenerator;

final public class BankServiceImpl implements BankService {
    //region ===================== Properties ======================
    private Map<String, Bank> bankMap = new HashMap<>();

    //region ===================== DI ======================
    @NotNull public BankOfficeService bankOfficeService;

    //region ===================== BankService implementation ======================
    @Override
    public @Nullable Bank create(@NotNull Bank bank) {
        bank.setRating(RandomGenerator.getDefault().nextInt(100));
        bank.setTotalMoney(RandomGenerator.getDefault().nextDouble(10_000, 1_000_000));
        this.calculateInterestRate(bank);
        return this.addBank(bank);
    }

    @Override
    public @Nullable Bank addBank(@NotNull Bank bank) {
        if (this.bankMap.containsKey(bank.getId())) { return null; }

        this.bankMap.put(bank.getId(), bank);
        return this.bankMap.get(bank.getId());
    }

    @Override
    public @Nullable Bank getBankById(@NotNull String bankId) {
        return this.bankMap.get(bankId);
    }

    @Override
    public @NotNull Boolean deleteBank(@NotNull String bankId) {
        if (!this.bankMap.containsKey(bankId)) {return false; }

        this.bankOfficeService.getOfficesByBankId(bankId).forEach(bankOffice ->
                this.removeOffice(bankId, bankOffice.getId())
        );

        return this.bankMap.remove(bankId) != null;
    }

    @Override
    public @NotNull List<Bank> getAllBanks() {
        return new ArrayList<>(this.bankMap.values());
    }

    @Override
    public void calculateInterestRate(@NotNull Bank bank) {
        int rating = bank.getRating();
        double offset = RandomGenerator.getDefault().nextDouble() * 4;

        if (rating < 30) {
            bank.setInterestRate(offset + 16);
        } else if (rating < 60) {
            bank.setInterestRate(offset + 11);
        } else if (rating < 90) {
            bank.setInterestRate(offset + 6);
        } else {
            bank.setInterestRate(offset + 1);
        }

    }

    @Override
    public void depositMoney(@NotNull String bankId, double sum) {
        Bank bank = this.bankMap.get(bankId);
        if (bank == null) { return; }

        bank.setTotalMoney(bank.getTotalMoney() + sum);
    }

    @Override
    public void withdrawMoney(@NotNull String bankId, double sum) {
        Bank bank = this.bankMap.get(bankId);
        if (bank == null) { return; }

        if (bank.getTotalMoney() >= sum) {
            bank.setTotalMoney(bank.getTotalMoney() - sum);
        } else {
            System.out.println("В банке недостаточно денег");
        }
    }

    @Override
    public void addOffice(@NotNull String bankId, @NotNull BankOffice office) {
        Bank bank = this.getBankById(bankId);
        if (bank == null) { return; }

        bank.setOfficesCount(bank.getOfficesCount() + 1);
        bank.setAtmsCount(bank.getAtmsCount() + office.getAtmsCount());

        this.depositMoney(bankId, office.getTotalCash());
    }

    @Override
    public @NotNull Boolean removeOffice(@NotNull String bankId, @NotNull String officeId) {
        Bank bank = this.getBankById(bankId);
        BankOffice bankOffice = this.bankOfficeService.getOfficeById(officeId);
        if (bank == null || bankOffice == null) { return false; }

        this.bankOfficeService.deleteOffice(officeId);
        bank.setOfficesCount(bank.getOfficesCount() - 1);
        this.withdrawMoney(bankId, bankOffice.getTotalCash());

        return true;
    }

    @Override
    public @NotNull Boolean addClient(@NotNull String bankId, @NotNull User user) {
        Bank bank = this.getBankById(bankId);
        if (bank == null) { return false; }

        user.setBank(bank);
        bank.setClientsCount(bank.getClientsCount() + 1);

        return true;
    }

    @Override
    public @NotNull Boolean removeClient(@NotNull String bankId, @NotNull String userId) {
        Bank bank = this.getBankById(bankId);
        if (bank == null) { return false; }

        bank.setClientsCount(bank.getClientsCount() - 1);
        return true;
    }

    @Override
    public @NotNull Boolean addEmployee(@NotNull String bankId, @NotNull Employee employee) {
        Bank bank = this.getBankById(bankId);
        if (bank == null) { return false; }

        employee.setBankOfWork(bank);
        bank.setEmployeesCount(bank.getEmployeesCount() + 1);

        return true;
    }

    @Override
    public @NotNull Boolean removeEmployee(@NotNull String bankId, @NotNull String employeeId) {
        Bank bank = this.getBankById(bankId);
        if (bank == null) { return false; }

        bank.setEmployeesCount(bank.getEmployeesCount() - 1);
        return true;
    }

    @Override
    public @NotNull Boolean isCreditAllowed(
            @NotNull String bankId,
            @NotNull CreditAccount creditAccount,
            @NotNull Employee employee
    ) {
        Bank bank = this.getBankById(bankId);
        if (bank == null) { return false; }

        double sum = creditAccount.getLoanAmount();
        if (bank.getTotalMoney() >= sum) {
            if (employee.getCanIssueLoans()) {
                double sumMonthPay = sum * (bank.getInterestRate() / 100 + 1) / creditAccount.getLoanMonthCount();

                if (creditAccount.getCustomer().getMonthlyIncome() > sumMonthPay) {
                    creditAccount.setEmployee(employee);
                    creditAccount.setMonthlyPayment(sumMonthPay);
                    creditAccount.setBank(bank);
                    creditAccount.setInterestRate((int)bank.getInterestRate());
                    creditAccount.setLoadEndDate(creditAccount.getLoanStartDate().plusMonths(creditAccount.getLoanMonthCount()));

                    return true;
                } else {
                    System.out.println("Пользовтель не может позволить себе погашение кредита");
                }
            } else {
                System.out.println("Данный сотрудник не может выдавать кредиты");
            }
        } else {
            System.out.println("В банке недостатоно денег для выдачи кредит");
        }

        return false;
    }
}
