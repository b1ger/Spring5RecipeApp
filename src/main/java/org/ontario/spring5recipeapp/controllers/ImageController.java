package org.ontario.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.ontario.spring5recipeapp.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/recipe/{id}/iamge")
    public String handleImageString(@PathVariable String id,
                                    @RequestParam MultipartFile file) {

        log.debug("ImageController -> upload image");
        imageService.saveImageFile(Long.parseLong(id), file);

        return "recipe/" + id + "/view";
    }
}
