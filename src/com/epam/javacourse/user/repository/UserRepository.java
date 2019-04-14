package com.epam.javacourse.user.repository;

import com.epam.javacourse.common.solutions.repository.BaseRepository;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepository extends BaseRepository<User, Long> {
    List<? extends User> search(UserSearchCondition searchCondition);
}
