package com.example.springboot4.repository;

import com.example.springboot4.model.Classz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClasszRepository extends JpaRepository<Classz,Long> {
}
