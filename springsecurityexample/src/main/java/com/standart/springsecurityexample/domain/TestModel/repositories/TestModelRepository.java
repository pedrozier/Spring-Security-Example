package com.standart.springsecurityexample.domain.TestModel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.standart.springsecurityexample.domain.TestModel.models.TestModel;

@EnableJpaRepositories
@Repository
public interface TestModelRepository extends JpaRepository<TestModel, Long> {

}
