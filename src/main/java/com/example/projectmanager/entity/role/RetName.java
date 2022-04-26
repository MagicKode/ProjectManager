package com.example.projectmanager.entity.role;


import org.springframework.data.jpa.domain.Specification;

public enum RetName /*implements Specification*/ {

    RET_A,
    RET_B


    /*@Override
    public Specification and(Specification other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification or(Specification other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        return null;
    }*/

}
