package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.CreditAccount;
import tech.reliab.course.anisimov.entity.PaymentAccount;
import tech.reliab.course.anisimov.entity.User;

import java.util.List;

public interface UserService {
    // Создание пользователя
    User create(User user);

    // Добавить пользователя
    User addUser(User user);

    // Получение пользователя по айди
    User getUserById(String userId);

    // Удаление пользователя
    Boolean deleteUser(String userId);

    // Получение всех пользователей банка
    List<User> getAllUsersByBankId(String bankId);

    // Добавить кредитный аккаунт
    Boolean addCreditAccount(String userId, CreditAccount creditAccount);

    // Удалить кредитный аккаунт
    Boolean removeCreditAccount(String userId, String accountId);

    // Добави платежный аккаунт
    Boolean addPaymentAccount(String userId, PaymentAccount paymentAccount);

    // Удалить платежный аккаунт
    Boolean removePaymentAccount(String userId, String paymentId);

    // Установить мето работы
    void registerJob(User user, String jobAddress, double monthlyIncome);

    // Посчитать кредитный рейтинг пользователя
    void calculateRating(User user);

}
