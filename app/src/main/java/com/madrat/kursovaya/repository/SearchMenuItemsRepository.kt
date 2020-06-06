package com.madrat.kursovaya.repository

import android.content.Context
import com.madrat.kursovaya.interfaces.SearchMenuItemsMVP
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import com.madrat.kursovaya.model.search_menu_items.SearchMenuItemsResponse
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchMenuItemsRepository: SearchMenuItemsMVP.Repository {
    override fun searchMenuItemsObservable(context: Context, apiKey: String,
                                           searchQuery: String, number: Int)
            : Observable<SearchMenuItemsResponse> {
        return NetworkClient(context).instance()
            .searchMenuItems(apiKey, searchQuery, number)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}