package com.programmingbytes.apirecipestutorial.recipe.service;

import com.programmingbytes.apirecipestutorial.recipe.model.Ingredient;
import com.programmingbytes.apirecipestutorial.recipe.model.Recipe;
import com.programmingbytes.apirecipestutorial.recipe.model.RecipeIngredient;
import com.programmingbytes.apirecipestutorial.recipe.model.RecipeIngredientId;
import com.programmingbytes.apirecipestutorial.recipe.repository.IngredientRepository;
import com.programmingbytes.apirecipestutorial.recipe.repository.RecipeIngredientRepository;
import com.programmingbytes.apirecipestutorial.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public RecipeIngredient save(RecipeIngredient recipeIngredient){

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeIngredient.getRecipe().getId());

        if(recipeOptional.isEmpty()){
            throw new IllegalStateException(
                    String.format("Recipe not found with id - %s", recipeIngredient.getRecipe().getId())
            );
        }

        recipeIngredient.setRecipe(recipeOptional.get());

        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(
                recipeIngredient.getIngredient().getId()
        );

        if(ingredientOptional.isEmpty()){
            throw new IllegalStateException(
                    String.format("Ingredient not found with id - %s", recipeIngredient.getIngredient().getId())
            );
        }

        recipeIngredient.setIngredient(ingredientOptional.get());


        RecipeIngredientId recipeIngredientId = new RecipeIngredientId(recipeIngredient.getRecipe().getId(), recipeIngredient.getIngredient().getId());

        recipeIngredient.setId(recipeIngredientId);


        return recipeIngredientRepository.save(recipeIngredient);
    }
}
