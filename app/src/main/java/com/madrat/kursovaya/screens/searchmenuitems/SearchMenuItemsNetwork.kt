package com.madrat.kursovaya.screens.searchmenuitems

import com.madrat.kursovaya.screens.searchmenuitems.model.SearchMenuItemsResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

// https://spoonacular.com/food-api/docs#Search-Menu-Items
interface SearchMenuItemsNetwork {
    @GET("food/menuItems/search")
    fun searchMenuItems(
        @Query("apiKey") apiKey: String,
        @Query("query") searchQuery: String,
        @Query("number") number: Int
    ): Observable<SearchMenuItemsResponse>
}