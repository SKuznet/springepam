package com.epam.learnspring.services;

import com.epam.learningspring.entity.Pet;

import java.util.List;

public interface PetService {

    /**
     * method for adding Pet to DB
     *
     * @param pet - Pet for adding
     * @return Pet's from DB
     */
    Pet add(Pet pet);

    /**
     * method for Pets updating to DB
     *
     * @param pet - Pet for update
     * @return updated Pet
     */
    Pet update(Pet pet);

    /**
     * method for Pet deletion
     *
     * @param id - Pet's id for delete
     * @return deleted Pet
     */
    Pet delete(long id);

    /**
     * method for getting Pet by id
     *
     * @param id - Pet's id
     * @return Pet by specific id
     */
    Pet getPetById(long id);

    /**
     * method for getting all Pets
     *
     * @return all Pets
     */
    List<Pet> getAllPets();
}
