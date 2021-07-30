package com.madrat.kursovaya.screens.getrecipeequipmentbyid

import com.madrat.kursovaya.screens.getrecipeequipmentbyid.model.GetRecipeEquipmentByIdResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// https://spoonacular.com/food-api/docs#Get-Recipe-Equipment-by-ID
interface GetRecipeEquipmentByIdNetwork {
    @GET("recipes/{id}/equipmentWidget.json")
    fun getRecipeEquipmentById(
        @Path("id") recipeId: Int,
        @Query("apiKey") apiKey: String
    ): Observable<GetRecipeEquipmentByIdResponse>
}