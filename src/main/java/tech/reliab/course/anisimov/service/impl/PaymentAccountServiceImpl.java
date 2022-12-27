package tech.reliab.course.anisimov.service.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.reliab.course.anisimov.entity.PaymentAccount;
import tech.reliab.course.anisimov.entity.User;
import tech.reliab.course.anisimov.service.PaymentAccountService;
import tech.reliab.course.anisimov.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final public class PaymentAccountServiceImpl implements PaymentAccountService {
    //region ===================== Properties ======================
    private Map<String, PaymentAccount> paymentAccountMap = new HashMap<>();

    //region ===================== DI ======================
    @NotNull public UserService userService;

    //region ===================== PaymentService implementation ======================
    @Override
    public @Nullable PaymentAccount create(@NotNull PaymentAccount paymentAccount) {
        return this.addAccount(new PaymentAccount(paymentAccount));
    }

    @Override
    public @Nullable PaymentAccount addAccount(@NotNull PaymentAccount account) {
        if (this.paymentAccountMap.containsKey(account.getId())) { return null; };

        User user = account.getUser();
        if (user != null) {
            this.paymentAccountMap.put(account.getId(), account);
            return account;
        }

        return null;
    }

    @Override
    public @NotNull Boolean deleteAccount(@NotNull String accountId) {
        PaymentAccount account = this.paymentAccountMap.get(accountId);
        if (account == null) { return false; }

        this.userService.removePaymentAccount(account.getUser().getId(), accountId);
        return this.paymentAccountMap.remove(accountId) != null;
    }

    @Override
    public @Nullable PaymentAccount getAccountById(@NotNull String accountId) {
        return this.paymentAccountMap.get(accountId);
    }

    @Override
    public @NotNull List<PaymentAccount> getUsersAccounts(@NotNull String userId) {
        return this.paymentAccountMap.values()
                .stream()
                .filter(account -> Objects.equals(account.getUser().getId(), userId))
                .toList();
    }

    @Override
    public void depositMoney(@NotNull PaymentAccount account, double sum) {
        account.setTotalCash(account.getTotalCash() + sum);
    }

    @Override
    public void withdrawMoney(@NotNull PaymentAccount account, double sum) {
        if (account.getTotalCash() > sum) {
            account.setTotalCash(account.getTotalCash() - sum);
        } else {
            System.out.println("На аккаунте недостаточно средств");
        }
    }

    @Override
    public @Nullable String stringRepresentation(@NotNull String accountId) {
        PaymentAccount paymentAccount = this.getAccountById(accountId);
        if (paymentAccount == null) {return null; }

        return paymentAccount.toString();
    }
}
