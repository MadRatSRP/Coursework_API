package com.madrat.kursovaya.screens.searchfoodvideos

import com.madrat.kursovaya.screens.searchfoodvideos.model.SearchFoodVideosResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

// https://spoonacular.com/food-api/docs#Search-Food-Videos
interface SearchFoodVideosNetwork {
    @GET("food/videos/search")
    fun getSearchFoodVideos(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("number") number: Int
    ): Observable<SearchFoodVideosResponse>
}