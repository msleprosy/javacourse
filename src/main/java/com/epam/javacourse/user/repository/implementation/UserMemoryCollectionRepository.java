package com.epam.javacourse.user.repository.implementation;

import com.epam.javacourse.common.business.search.Paginator;
import com.epam.javacourse.common.solutions.utils.CollectionUtils;
import com.epam.javacourse.storage.SequenceGenerator;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.repository.UserRepository;
import com.epam.javacourse.user.search.UserSearchCondition;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.epam.javacourse.storage.Storage.users;

public class UserMemoryCollectionRepository implements UserRepository {
    private UserOrderingComponent orderingComponent = new UserOrderingComponent();

    @Override
    public User add(User user) {
        user.setId(SequenceGenerator.getNextValue());
        users.add(user);
        return user;
    }

    @Override
    public void add(Collection<User> users) {
        users.forEach(this::add);
    }

    @Override
    public void update(User user) {

    }

    public Optional<User> findById(Long id) {
        return findUserById(id);
    }

    @Override
    public void deleteById(Long id) {
        findUserById(id).map(user -> users.remove(user));
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        List<? extends User> users = doSearch(searchCondition);

        if (!users.isEmpty() && searchCondition.shouldPaginate()) {
            users = getPageableData(users, searchCondition.getPaginator());
        }

        return users;
    }

    private List<? extends User> getPageableData(List<? extends User> users, Paginator paginator) {
        return CollectionUtils.getPageableData(users, paginator.getLimit(), paginator.getOffset());
    }

    private List<User> doSearch(UserSearchCondition searchCondition) {
        return users;
    }


/*    @Override
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
    }*/


    @Override
    public void printAll() {
        users.forEach(System.out::println);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public int countAll() {
        return users.size();
    }

/*
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
    }*/

    private Optional<User> findUserById(long userId) {
        return users.stream().filter(user -> Long.valueOf(userId).equals(user.getId())).findAny();
    }

}

