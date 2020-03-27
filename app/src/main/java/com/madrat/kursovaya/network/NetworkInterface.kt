package com.madrat.kursovaya.network

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
}