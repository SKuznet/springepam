package com.epam.learnspring.service;

import com.epam.learnspring.entity.Human;

import java.util.List;

public interface HumanService {

    /**
     * method for adding human to DB
     *
     * @param human - human for adding
     * @return human's from DB
     */
    Human add(Human human);

    /**
     * method for cats updating to DB
     *
     * @param human - human for update
     * @return updated human
     */
    Human update(Human human);

    /**
     * method for cat deletion
     *
     * @param id - cat's id for delete
     * @return deleted human
     */
    Human delete(long id);

    /**
     * method for getting human by id
     *
     * @param id - human's id
     * @return human by specific id
     */
    Human getHumanById(long id);

    /**
     * method for getting all humans
     *
     * @return all humans
     */
    List<Human> getAllHumans();
}
