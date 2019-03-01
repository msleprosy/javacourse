package com.epam.javacourse.user.search;

import com.epam.javacourse.user.service.UserMemoryService;
import com.epam.javacourse.common.solutions.BaseSearchIdCondition;

public class UserSearchIdCondition extends BaseSearchIdCondition {

    private UserMemoryService userMemoryService = new UserMemoryService();

    @Override
    public void search(Long id) {
        userMemoryService.findUserById(id);
    }
}
