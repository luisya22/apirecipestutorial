package com.programmingbytes.apirecipestutorial.recipe.service;

import com.programmingbytes.apirecipestutorial.recipe.model.Ingredient;
import com.programmingbytes.apirecipestutorial.recipe.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getAll(){
        return ingredientRepository.findAll();
    }

    public void delete(Long id){
        ingredientRepository.deleteById(id);
    }
}
