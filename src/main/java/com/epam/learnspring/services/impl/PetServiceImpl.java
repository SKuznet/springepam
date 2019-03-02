package com.epam.learnspring.services.impl;

import com.epam.learningspring.entity.Pet;
import com.epam.learningspring.repository.PetRepository;
import com.epam.learningspring.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private  PetRepository petRepository;


    @Override
    public Pet add(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet delete(long id) {
        Pet deleted = petRepository.findById(id).get();
        petRepository.deleteById( id);
        return deleted;
    }

    @Override
    public Pet getPetById(long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }
}
