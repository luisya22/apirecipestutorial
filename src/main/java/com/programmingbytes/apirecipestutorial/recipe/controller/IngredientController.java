package com.programmingbytes.apirecipestutorial.recipe.controller;

import com.programmingbytes.apirecipestutorial.recipe.model.Ingredient;
import com.programmingbytes.apirecipestutorial.recipe.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient){
        return ResponseEntity.ok(ingredientService.save(ingredient));
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAll(){
        return ResponseEntity.ok(ingredientService.getAll());
    }
}
