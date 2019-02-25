package com.epam.learnspring.service;

import com.epam.learnspring.entity.Cat;

import java.util.List;

public interface CatService {

    /**
     * method for adding cat to DB
     *
     * @param cat - cat for adding
     * @return cat's from DB
     */
    Cat add(Cat cat);

    /**
     * method for cats updating cat to DB
     *
     * @param cat - cat for update
     * @return updated cat
     */
    Cat update(Cat cat);

    /**
     * method for cat deletion
     *
     * @param id - cat for delete
     * @return deleted cat
     */
    Cat delete(long id);

    /**
     * method for getting cat by id
     *
     * @param id - cat's id
     * @return cat by specific id
     */
    Cat getCatById(long id);

    /**
     * method for all getting all cats
     *
     * @return all cats
     */
    List<Cat> getAllCats();

}