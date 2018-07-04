package org.ontario.spring5recipeapp.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ontario.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    public void findByDescription() {
        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", optional.get().getDescription());
    }

    @Test
    @DirtiesContext
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", optional.get().getDescription());
    }
}