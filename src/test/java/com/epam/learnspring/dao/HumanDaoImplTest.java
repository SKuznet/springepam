package com.epam.learnspring.dao;

import com.epam.learnspring.config.AppConfig;
import com.epam.learnspring.config.HibernateConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes = {AppConfig.class, HibernateConfig.class})
public class HumanDaoImplTest {
    @Autowired
    private HumanDao humanDao;

    @Test
    public void testGetCatListByName() {
        assertNotNull(humanDao.getCatListByName("Barsik"));
    }
}
