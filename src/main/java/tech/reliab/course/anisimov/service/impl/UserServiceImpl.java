package tech.reliab.course.anisimov.service.impl;

import tech.reliab.course.anisimov.entity.User;
import tech.reliab.course.anisimov.service.UserService;

final public class UserServiceImpl implements UserService {
    //region ===================== Properties ======================
    private User user = null;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Boolean updateUser(User user) {
        if (this.user == user) {
            setUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(User user) {
        if (this.user == user) {
            user = null;
            return true;
        } else {
            return false;
        }
    }
}
