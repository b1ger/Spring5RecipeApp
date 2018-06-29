package org.ontario.spring5recipeapp.bootstrap;

import org.ontario.spring5recipeapp.domain.*;
import org.ontario.spring5recipeapp.repositories.CategoryRepository;
import org.ontario.spring5recipeapp.repositories.RecipeRepository;
import org.ontario.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public void initData() {
        Category american = categoryRepository.findByDescription("American").get();
        Category mexican = categoryRepository.findByDescription("Mexican").get();

        UnitOfMeasure ripe = unitOfMeasureRepository.findByDescription("Ripe").get();
        UnitOfMeasure teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tbsp = unitOfMeasureRepository.findByDescription("Tbsp").get();
        UnitOfMeasure serrano = unitOfMeasureRepository.findByDescription("Serrano").get();
        UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash").get();
        UnitOfMeasure glove = unitOfMeasureRepository.findByDescription("Glove").get();
        UnitOfMeasure pound = unitOfMeasureRepository.findByDescription("Pound").get();

        Recipe guacamole = new Recipe();
        guacamole.setDescription("Guacamole is so easy. All you really need to make guacamole is ripe avocados and salt.");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(30);
        guacamole.setDifficulty(Difficulty.Medium);
        guacamole.setDirections("\"Guacamole Tip: Use Ripe Avocados\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The trick to making perfect guacamole is using good, ripe avocados.\\n\" +\n");
        guacamole.setServings(4);

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes(
                "\"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\\n\" +\n" +
                "                \"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\\n\" +\n" +
                "                \"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Variations\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\\n\"");
        guacamole.setNotes(guacNotes);
        guacNotes.setRecipe(guacamole);
        guacamole.getIngredients().add(new Ingredient("Avocado", new BigDecimal(2), ripe, guacamole));
        guacamole.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.5), teaSpoon, guacamole));
        guacamole.getIngredients().add(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(1), tbsp, guacamole));
        guacamole.getIngredients().add(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), tbsp, guacamole));
        guacamole.getIngredients().add(new Ingredient("Chiles, stems and seeds removed, minced", new BigDecimal(2), serrano, guacamole));
        guacamole.getIngredients().add(new Ingredient("Cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tableSpoon, guacamole));
        guacamole.getIngredients().add(new Ingredient("Freshly grated black pepper", new BigDecimal(1), dash, guacamole));
        guacamole.getIngredients().add(new Ingredient("Tomato", new BigDecimal(0.5), ripe, guacamole));

        guacamole.addCategory(american);
        guacamole.addCategory(mexican);

        guacamole.setSource("https://www.simplyrecipes.com");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

        recipeRepository.save(guacamole);

        Recipe taco = new Recipe();
        taco.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        taco.setServings(6);
        taco.setPrepTime(20);
        taco.setCookTime(15);
        taco.setDifficulty(Difficulty.Easy);
        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n");
        taco.setNotes(tacoNotes);
        tacoNotes.setRecipe(taco);
        taco.setSource("https://www.simplyrecipes.com");
        taco.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        taco.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tableSpoon, taco));
        taco.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), teaSpoon, taco));
        taco.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), teaSpoon, taco));
        taco.addIngredient(new Ingredient("salt", new BigDecimal(1/2), teaSpoon, taco));
        taco.addIngredient(new Ingredient("garlic", new BigDecimal(1/2), glove, taco));
        taco.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tableSpoon, taco));
        taco.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoon, taco));
        taco.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tableSpoon, taco));
        taco.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(1/4), pound, taco));
        taco.addCategory(american);;
        taco.addCategory(mexican);

        recipeRepository.save(taco);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
