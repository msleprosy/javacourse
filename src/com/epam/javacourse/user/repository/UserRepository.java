package com.epam.javacourse.user.repository;

public interface UserRepository extends BaseRepository {

    //void add(User user);

    void deleteByName(String nameForDeleting);

    //List<User> search(UserSearchCondition searchCondition);
}
