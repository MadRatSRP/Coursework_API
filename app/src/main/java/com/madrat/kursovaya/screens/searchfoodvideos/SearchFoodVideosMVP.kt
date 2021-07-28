package com.madrat.kursovaya.screens.searchfoodvideos

import android.content.Context
import com.madrat.kursovaya.screens.searchfoodvideos.model.SearchFoodVideosResponse
import com.madrat.kursovaya.screens.searchfoodvideos.model.Video
import io.reactivex.rxjava3.core.Observable

interface SearchFoodVideosMVP {
    interface View {

        fun initializePresenter()
        fun showListOfVideos(videos: ArrayList<Video>)
        fun showRecyclerView()
    }
    interface Presenter {

        fun doOnNext(videos: ArrayList<Video>)
        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
    }
    interface Repository {
        fun getSearchFoodVideosObservable(
            context: Context,
            apiKey: String,
            query: String,
            number: Int
        ): Observable<SearchFoodVideosResponse>
    }
}