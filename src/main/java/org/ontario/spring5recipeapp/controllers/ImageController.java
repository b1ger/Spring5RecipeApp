package org.ontario.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.ontario.spring5recipeapp.commands.RecipeCommand;
import org.ontario.spring5recipeapp.services.ImageService;
import org.ontario.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
public class ImageController {

    private ImageService imageService;
    private RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadFormAction(Model model, @PathVariable String id) {
        log.debug("ImageController uploadFormAction, recipeId - " + id);
        model.addAttribute("recipe", recipeService.findCommandById(Long.parseLong(id)));
        return "recipe/imageUploadForm";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImageString(@PathVariable String id,
                                    @RequestParam("imagefile") MultipartFile file) {

        log.debug("ImageController -> upload image");
        imageService.saveImageFile(Long.parseLong(id), file);

        return "redirect:/recipe/" + id + "/view";
    }

    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));

        if (recipeCommand.getImage() != null) {
            byte[] byteArray = new byte[recipeCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : recipeCommand.getImage()){
                byteArray[i++] = wrappedByte;
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
