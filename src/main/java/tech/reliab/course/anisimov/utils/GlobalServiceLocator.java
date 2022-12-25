package tech.reliab.course.anisimov.utils;

import tech.reliab.course.anisimov.service.AtmService;
import tech.reliab.course.anisimov.service.BankOfficeService;
import tech.reliab.course.anisimov.service.BankService;
import tech.reliab.course.anisimov.service.impl.AtmServiceImpl;
import tech.reliab.course.anisimov.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.anisimov.service.impl.BankServiceImpl;

import java.util.Objects;

public class GlobalServiceLocator {
    //region ===================== Properties ====================
    private static GlobalServiceLocator instance;

    private final BankService bankService = new BankServiceImpl();
    private final BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    private final AtmService atmService = new AtmServiceImpl();

    private GlobalServiceLocator() { initDependencies(); }

    //region ===================== Getters ====================
    public BankService getBankService() { return this.bankService; }

    public BankOfficeService getBankOfficeService() { return this.bankOfficeService; }

    public AtmService getAtmService() { return this.atmService; }

    //region ===================== Private ====================
    private void initDependencies() {
        ((AtmServiceImpl) this.atmService).bankOfficeService = bankOfficeService;

        ((BankOfficeServiceImpl) this.bankOfficeService).bankService = bankService;
        ((BankOfficeServiceImpl) this.bankOfficeService).atmService = atmService;
    }

    //region ===================== Static methods ====================
    public static GlobalServiceLocator getInstance() {
        return Objects.requireNonNullElseGet(instance, GlobalServiceLocator::new);
    }
}
