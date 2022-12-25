package tech.reliab.course.anisimov.service.impl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.service.AtmService;
import tech.reliab.course.anisimov.service.BankOfficeService;

import java.util.*;

final public class AtmServiceImpl implements AtmService {
    //region ===================== Properties ======================
    private final Map<String, BankAtm> bankAtmMap = new HashMap<>();

    //region ===================== DI ======================
    @NotNull public BankOfficeService bankOfficeService;

    //region ===================== Constructor ======================
    public AtmServiceImpl() {
    }

    //region ===================== AtmService implementation ======================
    @Override
    public @Nullable BankAtm create(@NotNull BankAtm bankAtm) {
        return this.addAtm(bankAtm);
    }

    @Override
    public @Nullable BankAtm addAtm(@NotNull BankAtm bankAtm) {
        if (this.bankAtmMap.containsKey(bankAtm.getId())) {
            System.out.println("Банкомат с таким id уже существует в системе");
            return null;
        }

        BankOffice bankOffice = bankAtm.getBankOffice();
        if (bankOffice != null) {
            this.bankAtmMap.put(bankAtm.getId(), bankAtm);
            this.bankOfficeService.addAtm(bankOffice.getId(), bankAtm);
            return bankAtm;
        } else {
            System.out.println("У банкомата не указан банк");
            return null;
        }
    }

    @Override
    public @Nullable BankAtm getAtmById(@NotNull String atmId) {
        return this.bankAtmMap.get(atmId);
    }

    @Override
    public @NotNull List<BankAtm> getAllAtms(@NotNull String bankId) {
        return new ArrayList<>(this.bankAtmMap.values());
    }

    @Override
    public @NotNull List<BankAtm> getAtmsByOfficeId(@NotNull String officeId) {
        return this.bankAtmMap.values()
                .stream()
                .filter(atm -> Objects.equals(atm.getBankOffice().getId(), officeId))
                .toList();
    }

    @Override
    public @NotNull List<BankAtm> getAtmsByBankId(@NotNull String bankId) {
        return this.bankAtmMap.values()
                .stream()
                .filter(atm -> Objects.equals(atm.getBank().getId(), bankId))
                .toList();
    }

    @Override
    public @NotNull Boolean deleteAtm(@NotNull String atmId) {
        BankAtm atm = this.bankAtmMap.get(atmId);
        if (atm == null) { return false; }


        if (this.bankOfficeService.removeAtm(atm.getBankOffice().getId(), atmId)) {
            return this.bankAtmMap.remove(atmId) != null;
        } else {
            return false;
        }
    }

    @Override
    public void depositMoney(@NotNull String atmId, double sum) {
        BankAtm atm = this.getAtmById(atmId);
        if (atm == null || atm.getBankOffice() == null || atm.getBank() == null) { return; }

        switch (atm.getStatus()) {
            case OPEN, RUN_OUT_OF_MONEY -> {
                if (atm.getCashDepositAvailable()) {
                    BankOffice bankOffice = atm.getBankOffice();
                    Bank bank = atm.getBank();
                    double newSum = atm.getTotalCash() + sum;

                    atm.setTotalCash(newSum);
                    bankOffice.setTotalCash(bankOffice.getTotalCash() + newSum);
                    bank.setTotalMoney(bank.getTotalMoney() + newSum);
                } else {
                    System.out.println("Внесение наличных возможных невозможно");
                }
            }
            case CLOSED -> {
                System.out.println("Банкомат закрыт");
            }

        }
    }

    @Override
    public void withdrawMoney(@NotNull String atmId, double sum) {
        BankAtm atm = this.getAtmById(atmId);
        if (atm == null || atm.getBank() == null || atm.getBankOffice() == null) { return; }

        switch (atm.getStatus()) {
            case OPEN -> {
                if (atm.getCashWithdrawalAvailable()) {
                    if (atm.getTotalCash() >= sum) {
                        BankOffice office = atm.getBankOffice();
                        Bank bank = atm.getBank();
                        double newSum = atm.getTotalCash() - sum;

                        atm.setTotalCash(newSum);
                        office.setTotalCash(office.getTotalCash() - newSum);
                        bank.setTotalMoney(bank.getTotalMoney() - newSum);
                    } else {
                        System.out.println("В банкомате недостаточно средств");
                    }
                } else {
                    System.out.println("Снятие наличных невозможно");
                }
            }
            case CLOSED -> {
                System.out.println("Банкомат закрыт");
            }
            case RUN_OUT_OF_MONEY -> {
                System.out.println("В банкомате закончились деньги");
            }
        }
    }
}
