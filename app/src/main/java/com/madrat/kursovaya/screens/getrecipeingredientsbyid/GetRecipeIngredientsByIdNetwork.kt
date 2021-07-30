package com.madrat.kursovaya.screens.getrecipeingredientsbyid

import com.madrat.kursovaya.screens.getrecipeingredientsbyid.model.GetRecipeIngredientsByIdResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetRecipeIngredientsByIdNetwork {
    // https://spoonacular.com/food-api/docs#Get-Recipe-Ingredients-by-ID
    @GET("recipes/{id}/ingredientWidget.json")
    fun getRecipeIngredientsById(
        @Path("id") recipeId: Int,
        @Query("apiKey") apiKey: String
    ): Observable<GetRecipeIngredientsByIdResponse>
}