package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.*;
import tech.reliab.course.anisimov.service.BankService;

import java.util.List;

final public class BankServiceImpl implements BankService {
    //region ===================== Properties ======================
    private Bank bank = null;

    //region ===================== BankService implementation ======================
    @Override
    public Bank create(Bank bank) {
        return null;
    }

    @Override
    public Bank addBank(Bank bank) {
        return null;
    }

    @Override
    public Bank getBankById(String bankId) {
        return null;
    }

    @Override
    public Boolean deleteBank(String bankId) {
        return null;
    }

    @Override
    public List<Bank> getAllBanks() {
        return null;
    }

    @Override
    public void calculateInterestRate(String bankId) {

    }

    @Override
    public void depositMoney(String bankId, double sum) {

    }

    @Override
    public void withdrawMoney(String bankId, double sum) {

    }

    @Override
    public void addOffice(String bankId, BankOffice office) {

    }

    @Override
    public Boolean removeOffice(String bankId, String officeId) {
        return null;
    }

    @Override
    public Boolean addClient(String bankId, User user) {
        return null;
    }

    @Override
    public Boolean removeClient(String bankId, String userId) {
        return null;
    }

    @Override
    public Boolean addEmployee(String bankId, Employee employee) {
        return null;
    }

    @Override
    public Boolean removeEmployee(String bankId, String employeeId) {
        return null;
    }

    @Override
    public boolean isCreditAllowed(String bankId, CreditAccount creditAccount, Employee employee) {
        return false;
    }
}
