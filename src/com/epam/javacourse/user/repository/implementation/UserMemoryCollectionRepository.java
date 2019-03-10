package com.epam.javacourse.user.repository.implementation;

import com.epam.javacourse.memory.SequenceGenerator;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.repository.UserRepository;
import com.epam.javacourse.user.search.UserSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.memory.Memory.users;

public class UserMemoryCollectionRepository implements UserRepository {
    private UserOrderingComponent orderingComponent = new UserOrderingComponent();

    @Override
    public void addUser(User user) {
        user.setId(SequenceGenerator.getNextValue());
        users.add(user);
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        deleteUserByName(nameForDeleting);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Long id) {
        return findUserById(id);
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        User found = findUserById(id);
        if (found != null) {
            users.remove(found);
            ;
        }
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<User> result = doSearch(searchCondition);

            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }


    @Override
    public void printAll() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private List<User> doSearch(UserSearchCondition searchCondition) {
        boolean searchByName = isNotBlank(searchCondition.getName());

        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user != null) {
                boolean found = true;

                if (searchByName) {
                    found = searchCondition.getName().equals(user.getName());
                }

                if (found) {
                    result.add(user);
                }
            }
        }
        return result;
    }

    private User findUserById(long userId) {
        for (User user : users) {
            if (Long.valueOf(userId).equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    private void deleteUserByName(String nameForDeleting) {
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            String userName = iter.next().getName();
            if (userName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }
}

