package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;
import tech.reliab.course.anisimov.service.BankOfficeService;
import tech.reliab.course.anisimov.service.BankService;

final public class BankOfficeServiceImpl implements BankOfficeService {
    //region ===================== DI ======================
    private final BankService bankService;

    //region ===================== Constructor ======================
    public BankOfficeServiceImpl(BankService bankService) {
        assert bankService != null;

        this.bankService = bankService;
    }

    //region ===================== BankOfficeService implementation ======================
    @Override
    public BankOffice create(BankOffice bankOffice) {
        assert bankOffice != null;

        bankService.addOffice(bankOffice.getBank(), bankOffice);
        return new BankOffice(bankOffice);
    }

    @Override
    public boolean addAtm(BankOffice bankOffice, BankAtm bankAtm) {
        return false;
    }

    @Override
    public boolean removeAtm() {
        return false;
    }

    @Override
    public void addEmployee(BankOffice bankOffice, Employee employee) {

    }

    @Override
    public void removeEmployee(BankOffice bankOffice, Employee employee) {

    }

    @Override
    public void depositMoney(BankOffice bankOffice, double sum) {

    }

    @Override
    public void withdrawMoney(BankOffice bankOffice, double sum) {

    }
}
