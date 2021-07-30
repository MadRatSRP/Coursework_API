package com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid

import com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid.model.GetRecipeNutritionWidgetByIdResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// https://spoonacular.com/food-api/docs#Get-Recipe-Nutrition-Widget-by-ID
interface GetRecipeNutritionWidgetByIdNetwork {
    @GET("recipes/{id}/nutritionWidget.json")
    fun getRecipeNutritionWidgetById(
        @Path("id") recipeId: Int,
        @Query("apiKey") apiKey: String
    ): Observable<GetRecipeNutritionWidgetByIdResponse>
}