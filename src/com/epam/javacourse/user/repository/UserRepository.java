package com.epam.javacourse.user.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;

public interface UserRepository extends BaseRepository {

    //void add(User user);

    void deleteByName(String nameForDeleting);

    //List<User> search(UserSearchCondition searchCondition);
}
