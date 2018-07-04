package org.ontario.spring5recipeapp.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.ontario.spring5recipeapp.repositories.CategoryRepository;
import org.ontario.spring5recipeapp.repositories.RecipeRepository;
import org.ontario.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.event.ContextRefreshedEvent;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DevBootstrapTest {

    private DevBootstrap devBootstrap;

    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;
    @Mock
    private ContextRefreshedEvent contextRefreshedEvent;

    @Before
    public void setUp() throws Exception {
        devBootstrap = new DevBootstrap(recipeRepository, categoryRepository, unitOfMeasureRepository);
    }

    @Test
    public void customTestMethod() {
//        devBootstrap.initData();
//
//        verify(devBootstrap, times(1)).initData();
    }
}