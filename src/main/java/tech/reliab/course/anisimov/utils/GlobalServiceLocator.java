package tech.reliab.course.anisimov.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import tech.reliab.course.anisimov.entity.CreditAccount;
import tech.reliab.course.anisimov.service.*;
import tech.reliab.course.anisimov.service.impl.*;

import java.util.Objects;

public class GlobalServiceLocator {
    //region ===================== Properties ====================
    private static GlobalServiceLocator instance;

    private final ObjectMapper jsonMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    private final BankService bankService = new BankServiceImpl(this.jsonMapper);
    private final BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    private final AtmService atmService = new AtmServiceImpl();
    private final UserService userService = new UserServiceImpl(this.jsonMapper);
    private final CreditAccountService creditAccountService = new CreditAccountServiceImpl();
    private final PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    //region ===================== Constructor ====================
    private GlobalServiceLocator() { initDependencies(); }

    //region ===================== Getters ====================
    public BankService getBankService() { return this.bankService; }

    public BankOfficeService getBankOfficeService() { return this.bankOfficeService; }

    public AtmService getAtmService() { return this.atmService; }

    public UserService getUserService() { return this.userService; }

    public CreditAccountService getCreditAccountService() { return this.creditAccountService; }

    public PaymentAccountService getPaymentAccountService() { return this.paymentAccountService; }

    public EmployeeService getEmployeeService() { return this.employeeService; }

    public ObjectMapper getJsonMapper() { return this.jsonMapper; }

    //region ===================== Private ====================
    private void initDependencies() {
        ((AtmServiceImpl) this.atmService).bankOfficeService = this.bankOfficeService;

        ((BankOfficeServiceImpl) this.bankOfficeService).bankService = this.bankService;
        ((BankOfficeServiceImpl) this.bankOfficeService).atmService = this.atmService;
        ((BankOfficeServiceImpl) this.bankOfficeService).employeeService = this.employeeService;

        ((CreditAccountServiceImpl) this.creditAccountService).bankService = this.bankService;
        ((CreditAccountServiceImpl) this.creditAccountService).userService = this.userService;

        ((UserServiceImpl) this.userService).creditAccountService = this.creditAccountService;
        ((UserServiceImpl) this.userService).paymentAccountService = this.paymentAccountService;
        ((UserServiceImpl) this.userService).bankService = this.bankService;

        ((PaymentAccountServiceImpl) this.paymentAccountService).userService = this.userService;

        ((EmployeeServiceImpl) this.employeeService).bankOfficeService = this.bankOfficeService;

        ((BankServiceImpl) this.bankService).bankOfficeService = this.bankOfficeService;
        ((BankServiceImpl) this.bankService).userService = this.userService;
    }

    //region ===================== Static methods ====================
    public static GlobalServiceLocator getInstance() {
        if (instance == null) {
            instance = new GlobalServiceLocator();
            return instance;
        } else {
            return instance;
        }
    }
}
