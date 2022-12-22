package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.entity.Employee;
import tech.reliab.course.anisimov.service.BankOfficeService;

final public class BankOfficeServiceImpl implements BankOfficeService {
    //region ===================== Properties ======================
    private BankOffice bankOffice = null;

    //region ===================== BankOfficeService implementation ======================
    @Override
    public BankOffice create(BankOffice bankOffice) {
        return null;
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
