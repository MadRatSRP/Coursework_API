package com.madrat.kursovaya.screens.generatemealplan

import com.madrat.kursovaya.screens.generatemealplan.model.GenerateMealPlanResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

// https://spoonacular.com/food-api/docs#Generate-Meal-Plan
interface GenerateMealPlanNetwork {
    @GET("mealplanner/generate")
    fun generateMealPlan(
        @Query("apiKey") apiKey: String,
        @Query("timeFrame") timeFrame: String
        /*@Query("targetCalories") targetCalories: Int,
        @Query("diet") diet: String,
        @Query("diet") diet: String*/
    ): Observable<GenerateMealPlanResponse>
}