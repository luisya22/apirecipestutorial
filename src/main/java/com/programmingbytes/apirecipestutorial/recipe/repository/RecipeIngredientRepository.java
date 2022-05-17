package com.programmingbytes.apirecipestutorial.recipe.repository;

import com.programmingbytes.apirecipestutorial.recipe.model.RecipeIngredient;
import com.programmingbytes.apirecipestutorial.recipe.model.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {
}
