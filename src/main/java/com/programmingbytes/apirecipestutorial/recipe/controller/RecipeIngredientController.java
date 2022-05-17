package com.programmingbytes.apirecipestutorial.recipe.controller;

import com.programmingbytes.apirecipestutorial.recipe.model.RecipeIngredient;
import com.programmingbytes.apirecipestutorial.recipe.service.RecipeIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/recipes/{recipeId}/ingredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @PostMapping
    public ResponseEntity<RecipeIngredient> save(@RequestBody RecipeIngredient recipeIngredient, @PathVariable(name="recipeId") Long recipeId){
        return ResponseEntity.ok(recipeIngredientService.save(recipeIngredient));
    }

}
