package tech.reliab.course.anisimov;

import tech.reliab.course.anisimov.entity.*;
import tech.reliab.course.anisimov.entity.internalComponents.Address;
import tech.reliab.course.anisimov.entity.internalComponents.FullName;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
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
                bank,
                true,
                bankOffice,
                true,
                50_000
        );

        BankAtm bankAtm = new BankAtm(
                "1",
                "testName",
                new Address("1", "Belgorod", "Kostykova 44"),
                false,
                bank,
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
                employee,
                paymentAccount
        );

        User user = new User(
                "1",
                new FullName("Name", "Surname"),
                new Date(),
                "somePlaceOfWork",
                100_000,
                bank,
                creditAccount,
                paymentAccount,
                100
        );

        paymentAccount.setUser(user);
        creditAccount.setCustomer(user);

        System.out.println(bank + "\n");
        System.out.println(bankAtm + "\n");
        System.out.println(bankOffice + "\n");
        System.out.println(creditAccount + "\n");
        System.out.println(employee + "\n");
        System.out.println(paymentAccount + "\n");
        System.out.println(user + "\n");
    }
}