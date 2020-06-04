package com.madrat.kursovaya.network

import com.madrat.kursovaya.model.generate_meal_plan.GenerateMealPlanResponse
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.GetRecipeEquipmentByIdResponse
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.GetRecipeIngredientsByIdResponse
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.GetRecipeNutritionWidgetByIdResponse
import com.madrat.kursovaya.model.get_similair_recipes.SimilarRecipe
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {
    // Search Food Videos
    // https://spoonacular.com/food-api/docs#Search-Food-Videos
    @GET("food/videos/search")
    fun getSearchFoodVideos(@Query("apiKey") apiKey: String,
                            @Query("query") query: String,
                            @Query("number") number: Int)
            : Observable<SearchFoodVideosResponse>

    // Generate Meal Plan
    // https://spoonacular.com/food-api/docs#Generate-Meal-Plan
    @GET("mealplanner/generate")
    fun generateMealPlan(@Query("apiKey") apiKey: String,
                         @Query("timeFrame") timeFrame: String
                         /*@Query("targetCalories") targetCalories: Int,
                         @Query("diet") diet: String,
                         @Query("diet") diet: String*/)
            : Observable<GenerateMealPlanResponse>

    // Get Recipe Equipment by ID
    // https://spoonacular.com/food-api/docs#Get-Recipe-Equipment-by-ID
    @GET("recipes/{id}/equipmentWidget.json")
    fun getRecipeEquipmentById(@Path("id") recipeId: Int,
                               @Query("apiKey") apiKey: String)
            : Observable<GetRecipeEquipmentByIdResponse>

    // Get Recipe Ingredients by ID
    // https://spoonacular.com/food-api/docs#Get-Recipe-Ingredients-by-ID
    @GET("recipes/{id}/ingredientWidget.json")
    fun getRecipeIngredientsById(@Path("id") recipeId: Int,
                                 @Query("apiKey") apiKey: String)
            : Observable<GetRecipeIngredientsByIdResponse>

    // Get Recipe Nutrition Widget by ID
    // https://spoonacular.com/food-api/docs#Get-Recipe-Nutrition-Widget-by-ID
    @GET("recipes/{id}/nutritionWidget.json")
    fun getRecipeNutritionWidgetById(@Path("id") recipeId: Int,
                                     @Query("apiKey") apiKey: String)
            : Observable<GetRecipeNutritionWidgetByIdResponse>

    // Get Similar Recipes
    // https://spoonacular.com/food-api/docs#Get-Similar-Recipes
    @GET("recipes/{id}/similar")
    fun getSimilarRecipes(@Path("id") recipeId: Int,
                          @Query("apiKey") apiKey: String,
                          @Query("number") numberOfRecipes: Int)
            : Observable<ArrayList<SimilarRecipe>>
}