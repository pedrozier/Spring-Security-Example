package com.standard.springsecurityexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.standard.springsecurityexample.models.TestModel;

@EnableJpaRepositories
@Repository
public interface TestModelRepository extends JpaRepository<TestModel, Long> {

}
