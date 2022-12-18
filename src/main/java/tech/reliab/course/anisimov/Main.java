package tech.reliab.course.anisimov;

import tech.reliab.course.anisimov.entity.*;
import tech.reliab.course.anisimov.entity.internalComponents.Address;
import tech.reliab.course.anisimov.entity.internalComponents.FullName;
import tech.reliab.course.anisimov.entity.internalComponents.OpenStatus;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(
                "1",
                "testTitle",
                1,
                1,
                1,
                1,
                5,
                100_000,
                4.5
                );

        BankOffice bankOffice = new BankOffice(
                "1",
                "someTitle",
                new Address("1", "Belgorod", "Chentr 13"),
                true,
                false,
                1,
                true,
                true,
                true,
                100_000,
                100
        );

        Date employeeBirthday = new Date(); employeeBirthday.setTime(883612800000L);
        Employee employee = new Employee(
                "1",
                new FullName("Test name", "Test surname", "Test patr"),
                employeeBirthday,
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
                OpenStatus.OPEN,
                false,
                bank.getId(),
                "testTitle",
                employee,
                true,
                false,
                100_000,
                500
        );

        PaymentAccount paymentAccount = new PaymentAccount(
                "1",
                null,
                "testTitle"
        );

        Date loanStartDate = new Date(); loanStartDate.setTime(1640995200000L);
        Date loanEndDate = new Date(); loanEndDate.setTime(1654041600000L);
        CreditAccount creditAccount = new CreditAccount(
                "1",
                null,
                "testTitle",
                loanStartDate,
                loanEndDate,
                6,
                100_000,
                10_000,
                12,
                employee.getId(),
                paymentAccount.getId()
        );

        Date userBirthday = new Date(); userBirthday.setTime(252460800000L);
        User user = new User(
                "1",
                new FullName("Name", "Surname"),
                userBirthday,
                "testTitle",
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