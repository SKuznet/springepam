package com.epam.learnspring.dao;

import com.epam.learnspring.config.AppConfig;
import com.epam.learnspring.config.HibernateConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, HibernateConfig.class})
public class CatDaoImplTest {
    @Autowired
    private CatDao catDao;

    @Test
    public void testGetCatListByName() {
        assertNotNull(catDao.getCatListByName("Barsik"));
    }
}
