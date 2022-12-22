package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.User;

public interface UserService {
    // Создание пользователя
    User create(User user);

    // Установить мето работы
    void registerJob(User user, String jobAddress, double monthlyIncome);

    // Посчитать кредитный рейтинг пользователя
    void calculateRating(User user);

}
