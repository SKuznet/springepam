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
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, HibernateConfig.class})
public class CatDaoTest {
    @Autowired
    private CatDao catDao;

    @Test
    public void checkCat() throws Exception {
        Assert.assertNotNull(catDao.getAll());
    }
}
