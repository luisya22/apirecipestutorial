package com.programmingbytes.apirecipestutorial.recipe.service;

import com.programmingbytes.apirecipestutorial.recipe.model.Recipe;
import com.programmingbytes.apirecipestutorial.recipe.model.RecipeStep;
import com.programmingbytes.apirecipestutorial.recipe.repository.RecipeRepository;
import com.programmingbytes.apirecipestutorial.recipe.repository.RecipeStepRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeStepService {

    private final RecipeStepRepository recipeStepRepository;
    private final RecipeRepository recipeRepository;

    public RecipeStepService(RecipeStepRepository recipeStepRepository, RecipeRepository recipeRepository) {
        this.recipeStepRepository = recipeStepRepository;
        this.recipeRepository = recipeRepository;
    }

    public RecipeStep save(Long recipeId, RecipeStep recipeStep){

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(recipeOptional.isEmpty()){
            throw new IllegalStateException(String.format("Recipe not found with id - %s", recipeId));
        }

        recipeStep.setRecipe(recipeOptional.get());

        return recipeStepRepository.save(recipeStep);
    }

    public void delete(Long recipeId, Long recipeStepId){

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(recipeOptional.isEmpty()){
            throw new IllegalStateException(String.format("Recipe not found with id - %s", recipeId));
        }

        Optional<RecipeStep> recipeStepOptional = recipeStepRepository.findByIdAndRecipeId(recipeStepId, recipeId);

        if(recipeStepOptional.isEmpty()){
            throw new IllegalStateException(String.format("Recipe step not found with recipe id %1$s and step id %2$s", recipeId, recipeStepId));
        }

        recipeStepRepository.delete(recipeStepOptional.get());
    }
}
