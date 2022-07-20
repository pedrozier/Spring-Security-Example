package com.standart.springsecurityexample.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.standart.springsecurityexample.domain.models.TestModel;
import com.standart.springsecurityexample.domain.repositories.TestModelRepository;

@RestController
@RequestMapping("/testmodel")
public class TestModelController {

    @Autowired
    TestModelRepository testModelRepository;

    @GetMapping("/findAll")
    public ResponseEntity<List<TestModel>> getAllTerstModels() {
        List<TestModel> testModelsList = testModelRepository.findAll();
        if (testModelsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<TestModel>>(testModelsList, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TestModel> getTestModel(@PathVariable(value = "id") Long id) {

        Optional<TestModel> testModelOptional = testModelRepository.findById(id);

        if (!testModelOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(testModelOptional.get(), HttpStatus.OK);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> saveTestModel(@RequestBody @Valid TestModel testModel) {
        testModelRepository.save(testModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTestModel(@PathVariable(value = "id") Long id) {
        Optional<TestModel> testModelOptional = testModelRepository.findById(id);
        if (!testModelOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            testModelRepository.delete(testModelOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTestModel(@PathVariable(value = "id") Long id,
            @RequestBody @Valid TestModel testModel) {
        Optional<TestModel> testModelOptional = testModelRepository.findById(id);
        if (!testModelOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            testModel.setId(testModelOptional.get().getId());
            testModelRepository.save(testModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
