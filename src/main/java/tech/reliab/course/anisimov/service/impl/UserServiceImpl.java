package tech.reliab.course.anisimov.service.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.reliab.course.anisimov.entity.Bank;
import tech.reliab.course.anisimov.entity.CreditAccount;
import tech.reliab.course.anisimov.entity.PaymentAccount;
import tech.reliab.course.anisimov.entity.User;
import tech.reliab.course.anisimov.service.BankService;
import tech.reliab.course.anisimov.service.CreditAccountService;
import tech.reliab.course.anisimov.service.PaymentAccountService;
import tech.reliab.course.anisimov.service.UserService;

import java.math.BigDecimal;
import java.util.*;

final public class UserServiceImpl implements UserService {
    //region ===================== Properties ======================
    private Map<String, User> userMap = new HashMap<>();

    //region ===================== DI ======================
    @NotNull public CreditAccountService creditAccountService;
    @NotNull public PaymentAccountService paymentAccountService;
    @NotNull public BankService bankService;

    //region ===================== UserServiceOverrides ======================
    @Override
    public @Nullable User create(@NotNull User user) {
        this.calculateRating(user);
        return this.addUser(new User(user));
    }

    @Override
    public @Nullable User addUser(@NotNull User user) {
        if (this.userMap.containsKey(user.getId())) { return null; }

        Bank bank = user.getBank();
        if (bank != null && this.bankService.addClient(bank.getId(), user)) {
            this.userMap.put(user.getId(), user);
            return user;
        }

        return null;
    }

    @Override
    public @NotNull List<User> getAllUsers() {
        return new ArrayList<>(this.userMap.values());
    }

    @Override
    public @Nullable User getUserById(@NotNull String userId) {
        return this.userMap.get(userId);
    }

    @Override
    public @NotNull Boolean deleteUser(@NotNull String userId) {
        User user = this.getUserById(userId);
        if (user == null) { return false; }

        this.paymentAccountService.getUsersAccounts(userId).forEach(account ->
                this.paymentAccountService.deleteAccount(account.getId())
        );
        this.creditAccountService.getUsersAccounts(userId).forEach(creditAccount ->
                this.creditAccountService.deleteAccount(creditAccount.getId())
        );
        this.bankService.removeClient(user.getBank().getId(), userId);

        return true;
    }

    @Override
    public @NotNull List<User> getAllUsersByBankId(@NotNull String bankId) {
        return this.userMap.values()
                .stream()
                .filter(user -> Objects.equals(user.getBank().getId(), bankId))
                .toList();
    }

    @Override
    public @NotNull Boolean addCreditAccount(@NotNull String userId, @NotNull CreditAccount creditAccount) {
        User user = this.getUserById(userId);
        if (user == null) { return false; }

        user.setCreditAccountsCount(user.getCreditAccountsCount() + 1);

        return true;
    }

    @Override
    public @NotNull Boolean removeCreditAccount(@NotNull String userId, @NotNull String accountId) {
        User user = this.getUserById(userId);
        if (user == null) { return false; }

        if (user.getCreditAccountsCount() > 0) {
            user.setCreditAccountsCount(user.getCreditAccountsCount() - 1);
            return true;
        }

        return false;
    }

    @Override
    public @NotNull Boolean addPaymentAccount(@NotNull String userId, @NotNull PaymentAccount paymentAccount) {
        User user = this.getUserById(userId);
        if (user == null) { return false; }

        user.setPaymentAccountsCount(user.getPaymentAccountsCount() + 1);

        return true;
    }

    @Override
    public @NotNull Boolean removePaymentAccount(@NotNull String userId, @NotNull String paymentId) {
        User user = this.getUserById(userId);
        if (user == null) { return false; }

        if (user.getPaymentAccountsCount() > 0) {
            user.setCreditAccountsCount(user.getPaymentAccountsCount() - 1);
            return true;
        }

        return false;
    }

    @Override
    public void registerJob(@NotNull User user, @NotNull String jobAddress, double monthlyIncome) {
        user.setPlaceOfWork(jobAddress);
        user.setMonthlyIncome(monthlyIncome);
        calculateRating(user);
    }

    @Override
    public void calculateRating(User user) {
        int rate = 100;
        BigDecimal value = BigDecimal.valueOf(1000L);

        while (BigDecimal.valueOf(user.getMonthlyIncome()).compareTo(value) > 0) {
            rate += 100;
            value = value.add(BigDecimal.valueOf(1000L));
        }

        user.setLoanRating(rate);
    }

    @Override
    public @Nullable String stringRepresentation(@NotNull String userId) {
        User user = this.getUserById(userId);
        if (user == null) { return null; }

        StringBuilder builder = new StringBuilder(user.toString());

        builder.append("Кредитные аккаунты:\n");
        this.creditAccountService.getUsersAccounts(userId).forEach(account ->
            builder.append(creditAccountService.stringRepresentation(account.getId())).append("\n")
        );

        builder.append("Платежные аккаунты:\n");
        this.paymentAccountService.getUsersAccounts(userId).forEach(account ->
            builder.append(this.paymentAccountService.stringRepresentation(account.getId())).append("\n")
        );

        builder.append("\n");
        return builder.toString();
    }
}
