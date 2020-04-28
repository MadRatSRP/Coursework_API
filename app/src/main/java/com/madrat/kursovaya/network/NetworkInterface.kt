package com.madrat.kursovaya.network

import com.madrat.kursovaya.model.generate_meal_plan.GenerateMealPlanResponse
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
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
}