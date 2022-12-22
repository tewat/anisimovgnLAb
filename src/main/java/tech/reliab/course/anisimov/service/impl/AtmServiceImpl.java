package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.entity.BankAtm;
import tech.reliab.course.anisimov.entity.BankOffice;
import tech.reliab.course.anisimov.service.AtmService;
import tech.reliab.course.anisimov.service.BankOfficeService;

final public class AtmServiceImpl implements AtmService {
    //region ===================== DI ======================
    private final BankOfficeService bankOfficeService;

    //region ===================== Constructor ======================
    public AtmServiceImpl(BankOfficeService bankOfficeService) {
        assert bankOfficeService != null;

        this.bankOfficeService = bankOfficeService;
    }

    //region ===================== AtmService implementation ======================
    @Override
    public BankAtm create(BankAtm bankAtm) {
        assert bankAtm != null;

        bankOfficeService.addAtm(bankAtm.getBankOffice(), bankAtm);
        return new BankAtm(bankAtm);
    }

    @Override
    public void depositMoney(BankAtm bankAtm, double sum) {
        assert bankAtm != null;

        switch (bankAtm.getStatus()) {
            case OPEN, RUN_OUT_OF_MONEY -> {
                if (bankAtm.getCashDepositAvailable()) {
                    double totalSum = bankAtm.getTotalCash() + sum;
                    BankOffice bankOffice = bankAtm.getBankOffice();
                    Bank bank = bankAtm.getBank();

                    bankAtm.setTotalCash(totalSum);
                    bankOffice.setTotalCash(bankOffice.getTotalCash() + totalSum);
                    bank.setTotalMoney(bank.getTotalMoney() + totalSum);
                } else {
                    System.out.println("Банкомат не работает на внесение наличных");
                }
            }
            case CLOSED -> {
                System.out.println("Банкомат закрыт");
            }
        }
    }

    @Override
    public void withdrawMoney(BankAtm bankAtm, double sum) {
        assert bankAtm != null;

        switch (bankAtm.getStatus()) {
            case OPEN -> {
                if (bankAtm.getCashWithdrawalAvailable()) {
                    if (bankAtm.getTotalCash() < sum) {
                        BankOffice office = bankAtm.getBankOffice();
                        Bank bank = bankAtm.getBank();
                        double newSum = bankAtm.getTotalCash() - sum;

                        bankAtm.setTotalCash(newSum);
                        office.setTotalCash(office.getTotalCash() - newSum);
                        bank.setTotalMoney(bank.getTotalMoney()- newSum);
                    } else {
                        System.out.println("В банкомате недостаточно средств");
                    }
                } else {
                    System.out.println("В банкомате недоступна выдача наличных");
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
