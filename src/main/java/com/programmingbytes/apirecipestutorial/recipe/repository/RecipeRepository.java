package com.programmingbytes.apirecipestutorial.recipe.repository;

import com.programmingbytes.apirecipestutorial.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
