package com.example.springboot4.service;

import java.util.Optional;

public interface IGeneralService <A>{
    Iterable<A> findAll();
    Optional<A> findById(Long id);
    void save(A a);
    void remote(Long id);
}
