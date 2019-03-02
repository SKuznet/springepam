package com.epam.learnspring.repository;

import com.epam.learningspring.entity.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {

     Boolean deleteById(int id);
}
