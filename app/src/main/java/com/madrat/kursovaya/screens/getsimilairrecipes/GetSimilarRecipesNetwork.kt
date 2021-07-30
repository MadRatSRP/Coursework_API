package com.madrat.kursovaya.screens.getsimilairrecipes

import com.madrat.kursovaya.screens.getsimilairrecipes.model.SimilarRecipe
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// https://spoonacular.com/food-api/docs#Get-Similar-Recipes
interface GetSimilarRecipesNetwork {
    @GET("recipes/{id}/similar")
    fun getSimilarRecipes(
        @Path("id") recipeId: Int,
        @Query("apiKey") apiKey: String,
        @Query("number") numberOfRecipes: Int
    ): Observable<ArrayList<SimilarRecipe>>
}