package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.User;
import tech.reliab.course.anisimov.service.UserService;

final public class UserServiceImpl implements UserService {
    //region ===================== Properties ======================
    private User user = null;

    //region ===================== UserServiceOvverides ======================
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void registerJob(User user, String jobAddress, double monthlyIncome) {

    }

    @Override
    public void calculateRating(User user) {

    }
}
