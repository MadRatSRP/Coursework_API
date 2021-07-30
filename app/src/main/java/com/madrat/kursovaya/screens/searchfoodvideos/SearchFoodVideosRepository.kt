package com.madrat.kursovaya.screens.searchfoodvideos

import android.content.Context
import com.madrat.kursovaya.screens.searchfoodvideos.model.SearchFoodVideosResponse
import com.madrat.kursovaya.util.AppDependencies
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchFoodVideosRepository: SearchFoodVideosMVP.Repository {
    private val networkService: SearchFoodVideosNetwork = AppDependencies.retrofit!!.create(
        SearchFoodVideosNetwork::class.java
    )
    
    override fun getSearchFoodVideosObservable(
        context: Context,
        apiKey: String,
        query: String,
        number: Int
    ): Observable<SearchFoodVideosResponse> {
        return networkService
            .getSearchFoodVideos(
                apiKey,
                query,
                number
            )
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(
                AndroidSchedulers.mainThread()
            )
    }
}