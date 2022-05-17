package com.programmingbytes.apirecipestutorial.recipe.repository;

import com.programmingbytes.apirecipestutorial.recipe.model.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeStepRepository extends JpaRepository<RecipeStep, Long> {

    Optional<RecipeStep> findByIdAndRecipeId(Long recipeStepId, Long recipeId);
}
