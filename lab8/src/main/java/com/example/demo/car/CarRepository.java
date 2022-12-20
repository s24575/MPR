package com.example.demo.car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByMake(String string);
    Car findByRegistration(String string);

//    @Override
//    Optional<Car> findById(Long id);
}