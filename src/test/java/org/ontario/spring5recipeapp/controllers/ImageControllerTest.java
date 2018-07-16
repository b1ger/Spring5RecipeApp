package org.ontario.spring5recipeapp.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.ontario.spring5recipeapp.services.ImageService;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ImageControllerTest {

    @Mock
    private ImageService imageService;
    private ImageController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.controller = new ImageController(imageService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHandleImagePost() throws Exception {
        MockMultipartFile multipartFile =
                new MockMultipartFile("file", "testing.txt", "text/plain", "Hello World from SpringBoot".getBytes());

        mockMvc.perform(multipart("/recipe/1/image").file(multipartFile))
               .andExpect(status().isFound())
               .andExpect(header().string("location", "/"));
    }
}