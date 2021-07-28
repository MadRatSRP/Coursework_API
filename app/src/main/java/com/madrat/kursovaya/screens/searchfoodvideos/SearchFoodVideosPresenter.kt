package com.madrat.kursovaya.screens.searchfoodvideos

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.screens.searchfoodvideos.model.Video

class SearchFoodVideosPresenter(private val view: SearchFoodVideosMVP.View,
                                private val repository: SearchFoodVideosMVP.Repository)
    : SearchFoodVideosMVP.Presenter{

    fun getSearchFoodVideosData(context: Context, apiKey: String,
                                query: String, number: Int) {
        val repository = repository.getSearchFoodVideosObservable(
            context, apiKey, query, number
        )
        repository.subscribe(
            {response ->
                doOnNext(response.videos)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(videos: ArrayList<Video>) {
        view.showListOfVideos(videos)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}