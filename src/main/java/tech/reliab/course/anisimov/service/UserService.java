package tech.reliab.course.anisimov.service;

import tech.reliab.course.anisimov.entity.User;

public interface UserService {
    User getUser();

    void setUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(User user);
}
