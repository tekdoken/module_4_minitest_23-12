package com.example.springboot4.service;

import com.example.springboot4.model.Classz;
import com.example.springboot4.repository.IClasszRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClasszService implements IClasszService{
    @Autowired
    IClasszRepository iClasszRepository;
    @Override
    public Iterable<Classz> findAll() {
        return iClasszRepository.findAll();
    }

    @Override
    public Optional<Classz> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Classz classz) {

    }

    @Override
    public void remote(Long id) {

    }
}
