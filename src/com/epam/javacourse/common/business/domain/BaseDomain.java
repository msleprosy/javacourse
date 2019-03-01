package com.epam.javacourse.common.business.domain;

/**
 * Created by veronika on 28.02.2019.
 */
public abstract class BaseDomain {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
