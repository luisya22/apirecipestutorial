package com.programmingbytes.apirecipestutorial.recipe.controller;

import com.programmingbytes.apirecipestutorial.recipe.model.Recipe;
import com.programmingbytes.apirecipestutorial.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe){
        return ResponseEntity.ok(recipeService.save(recipe));
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAll(){
        return ResponseEntity.ok(recipeService.getAll());
    }
}
