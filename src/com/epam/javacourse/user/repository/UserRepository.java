package com.epam.javacourse.user.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;
import com.epam.javacourse.user.domain.User;

public interface UserRepository extends BaseRepository {

    void addUser(User user);

    void deleteByName(String nameForDeleting);

    void update(User user);

    User findById(Long id);

    User findByName(String name);
}
