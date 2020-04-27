package com.madrat.kursovaya.repository

import android.content.Context
import com.madrat.kursovaya.interfaces.SearchFoodVideosMVP
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchFoodVideosRepository
    : SearchFoodVideosMVP.Repository {
    override fun getSearchFoodVideosObservable(context: Context, apiKey: String,
                                               query: String, number: Int)
            : Observable<SearchFoodVideosResponse>? {
        return NetworkClient.instance(context)
            ?.getSearchFoodVideos(apiKey, query, number)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}