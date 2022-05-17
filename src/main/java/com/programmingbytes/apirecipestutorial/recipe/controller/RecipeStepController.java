package com.programmingbytes.apirecipestutorial.recipe.controller;

import com.programmingbytes.apirecipestutorial.recipe.model.Recipe;
import com.programmingbytes.apirecipestutorial.recipe.model.RecipeStep;
import com.programmingbytes.apirecipestutorial.recipe.repository.RecipeRepository;
import com.programmingbytes.apirecipestutorial.recipe.service.RecipeStepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/recipes/{recipeId}/steps")
public class RecipeStepController {

    private final RecipeStepService recipeStepService;

    public RecipeStepController(RecipeStepService recipeStepService) {
        this.recipeStepService = recipeStepService;
    }

    @PostMapping
    public ResponseEntity<RecipeStep> save(@RequestBody RecipeStep recipeStep, @PathVariable(name = "recipeId") Long recipeId){
        return ResponseEntity.ok(recipeStepService.save(recipeId, recipeStep));
    }
}
