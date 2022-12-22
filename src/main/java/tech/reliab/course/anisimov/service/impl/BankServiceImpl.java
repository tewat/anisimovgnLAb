package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.*;
import tech.reliab.course.anisimov.service.BankService;

final public class BankServiceImpl implements BankService {
    //region ===================== Properties ======================
    private Bank bank = null;

    //region ===================== BankService implementation ======================
    @Override
    public Bank create(Bank bank) {
        return null;
    }

    @Override
    public void calculateInterestRate(Bank bank) {

    }

    @Override
    public void depositMoney(Bank bank, double sum) {

    }

    @Override
    public void withdrawMoney(Bank bank, double sum) {

    }

    @Override
    public void addOffice(Bank bank, BankOffice office) {

    }

    @Override
    public void removeOffice(Bank bank, BankOffice office) {

    }

    @Override
    public void addClient(Bank bank, User user) {

    }

    @Override
    public void removeClient(Bank bank, User user) {

    }

    @Override
    public void addEmployee(Bank bank, Employee employee) {

    }

    @Override
    public void removeEmployee(Bank bank, Employee employee) {

    }

    @Override
    public boolean isCreditAllowed(Bank bank, CreditAccount creditAccount, Employee employee) {
        return false;
    }
}
