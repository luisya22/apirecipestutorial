package com.programmingbytes.apirecipestutorial.recipe.service;

import com.programmingbytes.apirecipestutorial.recipe.model.Recipe;
import com.programmingbytes.apirecipestutorial.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAll(){
        return recipeRepository.findAll();
    }



    public void delete(Long id){
        recipeRepository.deleteById(id);
    }
}
