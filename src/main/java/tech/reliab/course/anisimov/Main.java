package tech.reliab.course.anisimov;

import tech.reliab.course.anisimov.entity.*;
import tech.reliab.course.anisimov.entity.internalComponents.Address;
import tech.reliab.course.anisimov.entity.internalComponents.FullName;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("1", "testTitle");

        BankOffice bankOffice = new BankOffice(
                "1",
                "someTitle",
                new Address("1", "Belgorod", "Chentr 13"),
                true,
                false,
                3,
                true,
                true,
                true,
                100_000,
                100
        );

        Employee employee = new Employee(
                "1",
                new FullName("Test name", "Test surname", "Test patr"),
                new Date(),
                "someJobPosition",
                bank.getId(),
                true,
                bankOffice.getId(),
                true,
                50_000
        );

        BankAtm bankAtm = new BankAtm(
                "1",
                "testName",
                new Address("1", "Belgorod", "Kostykova 44"),
                false,
                bank.getId(),
                "somePlacement",
                employee,
                true,
                false,
                100_000,
                500
        );

        PaymentAccount paymentAccount = new PaymentAccount(
                "1",
                null,
                "someBankName"
        );

        CreditAccount creditAccount = new CreditAccount(
                "1",
                null,
                "someBankName",
                new Date(),
                new Date(),
                100_000,
                100_000,
                10_000,
                12,
                employee.getId(),
                paymentAccount.getId()
        );

        User user = new User(
                "1",
                new FullName("Name", "Surname"),
                new Date(),
                "somePlaceOfWork",
                100_000,
                bank.getId(),
                creditAccount.getId(),
                paymentAccount.getId(),
                100
        );

        paymentAccount.setUserId(user.getId());
        creditAccount.setCustomerId(user.getId());

        System.out.println(bank + "\n");
        System.out.println(bankAtm + "\n");
        System.out.println(bankOffice + "\n");
        System.out.println(creditAccount + "\n");
        System.out.println(employee + "\n");
        System.out.println(paymentAccount + "\n");
        System.out.println(user + "\n");
    }
}